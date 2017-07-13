package simplekafka08.simplekafka08;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gimis.emcs.ps.msg.Message;
import com.gimis.emcs.ps.msg.gpsbody.GpsBasicInfo;
import com.gimis.emcs.ps.msg.mcubody.McuBody;
import com.gimis.emcs.ps.msg.mcubody.impl.BaseMcuCanDataPass;
import com.gimis.emcs.ps.msg.vo.CanDataVo;


import com.wlwltech.redis.update.model.ObjectModelOfKafka;
import com.wlwltech.redis.update.model.Pair;

public class HandleThread implements Runnable {
	// private Lock lock = new ReentrantLock(); // 注意这个地方
	byte[] sentence;
	private static final Logger logger = LoggerFactory.getLogger(HandleThread.class);
	public HandleThread(byte[] temp) {
		this.sentence = temp;

	}

	public void run() {
		
		SimpleDateFormat DEFAULT_DATE_SIMPLEDATEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Message message = getMessage();

		if (message != null) {

			if (message.getAppend() == null) {
				return;
			}
			Integer machineryId = message.getAppend().getMachineryId();
			// 超过5分钟的数据，自动丢弃，不做计算
			if (new Date().getTime() - message.getAppend().getServerTime().getTime() > 5 * 1000 * 60) {
				logger.info(
						machineryId + "/" + DEFAULT_DATE_SIMPLEDATEFORMAT.format(message.getAppend().getServerTime()));
				return;
			}
			try {

				McuBody mcuO = message.getMcuBody();
				if (mcuO == null) {
					return;
				}
				BaseMcuCanDataPass mcu = (BaseMcuCanDataPass) mcuO;
				// 获取配置文件中，协议、字段、别名对照表
				Map<String, Map<String, Pair>> valueCans = publicStaticMap.getCans();
				// 根据车辆id获取到车辆协议
				String protocol = publicStaticMap.getVehicle().get(machineryId.toString());
				if (mcu != null) {

					List<Pair> pairs = new ArrayList<Pair>();
					List<CanDataVo> cans = mcu.getCanDataFrame();
					if (cans == null) {
						return;
					}
					for (CanDataVo can : cans) {

						if (can == null) {
							continue;
						}
						String canid = can.getCanId();

						try {
							Map<String, Pair> pairsMap = new HashMap<>();
							// Can是正常的车辆数据
							if (valueCans.containsKey(protocol + "-" + canid)) {
								pairsMap = valueCans.get(protocol + "-" + canid);
								getPairs(pairsMap, can, pairs);
							} else if (valueCans.containsKey("-1" + "-" + canid))// 共用的车辆can数据
							{
								pairsMap = valueCans.get("-1" + "-" + canid);
								getPairs(pairsMap, can, pairs);

							} else {

//								Map<String, Object> canMap = can.getCanContentMap();
//								if (canMap == null) {
//									continue;
//								}
//								for (Map.Entry<String, Object> entry : canMap.entrySet()) {
//									if (entry == null) {
//										continue;
//									}
//									Pair pair = new Pair();
//									pair.setAlias(entry.getKey().toUpperCase());
//									pair.setCode(entry.getKey());
//									pair.setValue(entry.getValue().toString());
//									pairs.add(pair);
//								}
							}
						} catch (Exception ex) {
							//System.out.println("HandleThread-run-1");
							logger.error("HandleThread-run-1",ex);
							
						}
					}
					if (pairs.size() == 0) {
						return;
					}

					ObjectModelOfKafka modelKafka = new ObjectModelOfKafka();
					Double lat = mcu.getLatitude();
					Double lng = mcu.getLongitude();
					if (lat != null && lng != null && lat > 0 && lng > 0) {
						modelKafka.setCalEncrypLongitude(lat);
						modelKafka.setCalEncrypLatitude(lng);
					}
					modelKafka.setMachineryId(String.valueOf(machineryId));
					modelKafka.setDATIME_RX(DEFAULT_DATE_SIMPLEDATEFORMAT.format(message.getAppend().getServerTime()));
					modelKafka.setPairs(pairs);
					modelKafka.setAnalyzeType(protocol);
					publicStaticMap.getQueue().put(modelKafka);
				}
			} catch (Exception ex) {
				//System.out.println("HandleThread-run");
				//ex.printStackTrace();
				
				logger.error("HandleThread-run",ex);
			} finally {

				// lock.unlock();
			}
		}

	}

	private void getPairs(Map<String, Pair> pairsMap, CanDataVo can, List<Pair> pairs) {
		if(can==null)
		{
			return;
		}
		Map<String, Object> canMap = can.getCanContentMap();
		if (canMap == null) {
			return;
		}
		for (Map.Entry<String, Object> entry : canMap.entrySet()) {
			if (entry == null) {
				continue;
			}
			try{
			if (pairsMap.containsKey(entry.getKey())) {
				Pair pairnew = new Pair();
				Pair pair = pairsMap.get(entry.getKey());
				if (pair == null) {
					pairnew.setAlias(entry.getKey().toUpperCase());
					pairnew.setCode(entry.getKey());
				} else {
					pairnew.setAlias(pair.getAlias());
					pairnew.setCode(pair.getCode());
					pairnew.setTitle(pair.getTitle());
				}
				pairnew.setValue(entry.getValue().toString());
				pairs.add(pairnew);
			}
			}catch(Exception ex)
			{
				
				logger.error("getPairs",ex);
			
			}
		}
	}

	public Pair getSOC(List<Pair> pairs) {
		for (Pair p : pairs) {
			if (p.getAlias().equals("SOC")) {
				return p;
			}
		}
		return new Pair();

	}

	private Message getMessage() {
		Message obj = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			bis = new ByteArrayInputStream(sentence);
			ois = new ObjectInputStream(bis);
			obj = (Message) ois.readObject();
		} catch (IOException ex) {
			//System.out.println("HandleThread-getMessage");
			//ex.printStackTrace();
			logger.error("HandleThread-getMessage",ex);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (null != bis) {
					bis.close();
				}
				if (null != ois) {
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return obj;
	}

}
