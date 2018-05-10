package simplekafka08.simplekafka08;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wlwltech.pages.SensorIndex;
import com.wlwltech.redis.update.model.ObjectModelOfKafka;
import com.wlwltech.redis.update.model.ObjectModelOfRedis;
import com.wlwltech.redis.update.model.VehicleIndex;

public class SaveDataToES extends Thread {

	private static final Logger logger = LoggerFactory.getLogger(SaveDataToES.class);

	public SaveDataToES() {
		logger.error("启动ES程序");

	}

	@Override
	public void run() {
		SimpleDateFormat DEFAULT_DATE_SIMPLEDATEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// TODO Auto-generated method stub
		while (true) {
			try {
				// logger.error(String.valueOf(publicStaticMap.getQueueES().size()));
				ObjectModelOfRedis message = publicStaticMap.getQueueES().take();
				// logger.error(
				// message.getRedisValues().get("calEncrypLongitude"));
				if (message.getRedisValues().get("calEncrypLongitude") == null
						|| message.getRedisValues().get("calEncrypLongitude").isEmpty()
						|| message.getRedisValues().get("calEncrypLatitude") == null
						|| message.getRedisValues().get("calEncrypLatitude").isEmpty()) {
					continue;
				}
				double lng = Double.parseDouble(message.getRedisValues().get("calEncrypLongitude"));
				double lat = Double.parseDouble(message.getRedisValues().get("calEncrypLatitude"));

				VehicleIndex vi = new VehicleIndex();
				double[] tempArray = { lng, lat };
				vi.setLocation(tempArray);
				vi.setTime(DEFAULT_DATE_SIMPLEDATEFORMAT.parse(message.getRedisValues().get("lastCanTime")).getTime());
				vi.setOnLine(Integer.parseInt(message.getRedisValues().get("onLine")));
				vi.setVehicleUnid(message.getKey());
				if(System.currentTimeMillis()-vi.getTime()<3000000)
				{
					SensorIndex  si=new SensorIndex();
					si.setValue(vi, "vehicle_status");
				}
			
				// logger.error(message.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("添加ES错误", e);
			}

		}
}}
