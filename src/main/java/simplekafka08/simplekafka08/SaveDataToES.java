package simplekafka08.simplekafka08;



import com.wlwltech.pages.SensorIndex;
import com.wlwltech.redis.update.model.ObjectModelOfKafka;
import com.wlwltech.redis.update.model.ObjectModelOfRedis;
import com.wlwltech.redis.update.model.VehicleIndex;

public class SaveDataToES extends Thread {



	public SaveDataToES() {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				ObjectModelOfRedis message = publicStaticMap.getQueueES().take();
				VehicleIndex vi= new VehicleIndex();
				double [] tempArray=new double[]{Double.parseDouble(message.getRedisValues().get("calEncrypLongitude")),Double.parseDouble(message.getRedisValues().get("calEncrypLatitude"))};
				vi.setLocation(tempArray);
				vi.setTime(Long.parseLong(message.getRedisValues().get("lastCommunicateTime")));
				SensorIndex.setValue(vi, "");
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
	}
}
