package simplekafka08.simplekafka08;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

import com.wlwltech.csrzic.redis.PropertyResource;
import com.wlwltech.csrzic.redis.RedisPool;


public class MyTaskOnLine extends TimerTask {



	public MyTaskOnLine() {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Map<String, String> vehicles = publicStaticMap.getVehicle();
		try {
			PropertyResource.getInstance().setPropertyResource();
			HashMap<String, String> prop = PropertyResource.getInstance().getProperties();
			for (String id : vehicles.keySet()) {

				SimpleDateFormat DEFAULT_DATE_SIMPLEDATEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateTimeStr = RedisPool.getInstance().getJedisCluster().hget("mach:" + id,
						"lastCommunicateTime");
				
				
				
				if(prop.get("clearRedisMILEAGE")!=null&&prop.get("clearRedisMILEAGE").equals("true"))
				{
					RedisPool.getInstance().getJedisCluster().hset("mach:" + id, "MILEAGE", "0");
				}
				
				if (dateTimeStr != null && !dateTimeStr.isEmpty()) {
					Date dataDate;
					dataDate = DEFAULT_DATE_SIMPLEDATEFORMAT.parse(dateTimeStr);
					//System.out.println("间隔时间：" + (new Date().getTime() - dataDate.getTime()));
					if (new Date().getTime() - dataDate.getTime() > 1000 * 60 * 5) {
						RedisPool.getInstance().getJedisCluster().hset("mach:" + id, "onLine", "0");
					    String onllTemp = RedisPool.getInstance().getJedisCluster().hget("mach:" + id, "onLine");
						System.out.println("更新车辆状态:" + id + "-" + onllTemp);
					}
				} else {
					RedisPool.getInstance().getJedisCluster().hset("mach:" + id, "onLine", "0");
					//String onllTemp = RedisPool.getInstance().getJedisCluster().hget("mach:" + id, "onLine");
					//System.out.println("更新车辆状态:" + id + "-" + onllTemp);
				}
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
