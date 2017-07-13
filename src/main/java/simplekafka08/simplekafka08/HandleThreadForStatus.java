package simplekafka08.simplekafka08;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gimis.emcs.ps.msg.Message;
import com.gimis.emcs.ps.msg.gpsbody.GpsBasicInfo;
import com.gimis.emcs.ps.msg.gpsbody.GpsBody;
import com.gimis.emcs.ps.msg.gpsbody.impl.GpsHeartBeat;
import com.gimis.emcs.ps.msg.mcubody.McuBody;
import com.gimis.emcs.ps.msg.mcubody.impl.BaseMcuCanDataPass;
import com.gimis.emcs.ps.msg.vo.CanDataVo;
import com.gimis.emcs.util.PointDouble;
import com.gimis.emcs.util.Wars2Wgs;

import com.wlwltech.redis.update.model.ObjectModelOfRedis;
import com.wlwltech.redis.update.model.Pair;

public class HandleThreadForStatus extends Thread {
	// private static Map<String, Date> dateMap = new HashMap<String, Date>();

	private static final Logger logger = LoggerFactory.getLogger(HandleThreadForStatus.class);
  private byte[] sentence;
	public HandleThreadForStatus(byte[] temp) {
		 this.sentence = temp;
	}

	public void run() {
		//while (true) {
			byte[] sentence = this.sentence;
//			try {
//				sentence = publicStaticMap.getMessageQueue().take();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			SimpleDateFormat DEFAULT_DATE_SIMPLEDATEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			if (sentence == null) {
				return;
			}
			Message message = getMessage(sentence);

			if (message == null) {
				return;
			}
			if (message != null) {

				if (message.getAppend() == null) {
					return;
				}

				Integer machineryId = message.getAppend().getMachineryId();

				if (machineryId == null) {
					return;
				}

				Date date = message.getAppend().getServerTime();
				if (date == null) {
					return;
				}
				if (new Date().getTime() - date.getTime() > 2 * 1000 * 60) {

					logger.info("抛弃" + machineryId + "/"
							+ DEFAULT_DATE_SIMPLEDATEFORMAT.format(message.getAppend().getServerTime()));
					return;
				}

				Map<String, String> values = new HashMap<String, String>();
				values.put("lastLocateTime", DEFAULT_DATE_SIMPLEDATEFORMAT.format(message.getAppend().getServerTime()));
				try {
					McuBody mcuBody = message.getMcuBody();
					if (mcuBody != null) {
						BaseMcuCanDataPass mcu = (BaseMcuCanDataPass) mcuBody;
						Double speed = 0.0;
						values.put("lastCanTime", DEFAULT_DATE_SIMPLEDATEFORMAT.format(mcu.getUtcTime()));
						speed = mcu.getGpsSpeed();

						if (speed > 5) {
							values.put("onLine", "15");
						} else {
							values.put("onLine", "10");
						}
						Double lat = mcu.getLatitude();
						Double lng = mcu.getLongitude();
						if (lat != null && lng != null && lat != 0 && lng != 0) {

							PointDouble latlng = Wars2Wgs.s2c(new PointDouble(lng, lat));
							if (latlng != null) {
								values.put("calEncrypLongitude", String.valueOf(latlng.x));
								values.put("calEncrypLatitude", String.valueOf(latlng.y));
							}
						}
						Map<String, Map<String, Pair>> valueCans = publicStaticMap.getCans();

						String protocol = publicStaticMap.getVehicle().get(machineryId.toString());
						List<CanDataVo> cans = mcu.getCanDataFrame();

						for (CanDataVo can : cans) {
							String canid = can.getCanId();
							if (canid == null) {
								continue;
							}
							Map<String, Pair> pairsMap = new HashMap<>();
							if (valueCans != null && valueCans.containsKey(protocol + "-" + canid)) {
								pairsMap = valueCans.get(protocol + "-" + canid);
								// 如果为null不属于专属协议
							} else if (valueCans != null && valueCans.containsKey("-1" + "-" + canid)) {
								// 获取公共can针值
								pairsMap = valueCans.get("-1" + "-" + canid);
							}
							Map<String, Object> canMap = can.getCanContentMap();
							if (canMap == null) {
								continue;
							}
							for (Map.Entry<String, Object> entry : canMap.entrySet()) {
								if (entry == null) {
									continue;
								}
								if (entry.getKey() == null) {
									continue;
								}
								if (entry.getKey().isEmpty()) {
									continue;
								}
								if (entry.getValue() == null) {
									continue;
								}
								if (pairsMap != null) {
									if (pairsMap.containsKey(entry.getKey())) {

										Pair pair = pairsMap.get(entry.getKey());
										if (pair == null) {
											continue;
										}

										if (pair.getAlias() != null && !pair.getAlias().isEmpty()) {
											values.put(pair.getAlias(), entry.getValue().toString());
										} else {
											values.put(pair.getCode().toUpperCase(), entry.getValue().toString());
										}

									}
								}
								values.put(entry.getKey().toUpperCase(), entry.getValue().toString());
							}
						}
						if (message.getAppend().getServerTime() != null) {
							values.put("lastCommunicateTime",
									DEFAULT_DATE_SIMPLEDATEFORMAT.format(message.getAppend().getServerTime()));
						}
						ObjectModelOfRedis redisValues = new ObjectModelOfRedis();
						redisValues.setKey(machineryId.toString());
						redisValues.setRedisValues(values);

						publicStaticMap.getRedisValuesQueue().put(redisValues);

					}else {
						
						
					}

				} catch (Exception ex) {
					logger.error("", ex);
				}
			}
		//}

	}

	private Message getMessage(byte[] sentence) {
		Message obj = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			bis = new ByteArrayInputStream(sentence);
			ois = new ObjectInputStream(bis);
			obj = (Message) ois.readObject();
		} catch (IOException ex) {
			logger.error("", ex);
		} catch (ClassNotFoundException ex) {
			logger.error("", ex);
			try {
				if (null != bis) {
					bis.close();
				}
				if (null != ois) {
					ois.close();
				}
			} catch (IOException e) {
				logger.error("", ex);
			}
		}

		return obj;
	}

	

}
