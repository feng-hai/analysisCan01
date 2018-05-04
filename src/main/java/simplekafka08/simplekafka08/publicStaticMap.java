package simplekafka08.simplekafka08;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import com.wlwltech.redis.update.model.ObjectModelOfKafka;
import com.wlwltech.redis.update.model.ObjectModelOfRedis;
import com.wlwltech.redis.update.model.Pair;

public class publicStaticMap {
	
	private  publicStaticMap()
	{
		
	}
	private static Map<String,Map<String, Pair>> values=new ConcurrentHashMap <>();
	
	private static  Map<String,String >vehicles=new ConcurrentHashMap <>();
	private static BlockingQueue<ObjectModelOfKafka> queue = new LinkedBlockingQueue<ObjectModelOfKafka>();
	
    private static  BlockingQueue<ObjectModelOfRedis>redisQueue= new LinkedBlockingQueue<ObjectModelOfRedis>();
    
    private static  BlockingQueue<byte[]>messageQueue= new LinkedBlockingQueue<byte[]>();
    //保存到ES临时插件
    private static BlockingQueue<ObjectModelOfRedis> queueES = new LinkedBlockingQueue<ObjectModelOfRedis>();
    
	/**
	 * @return the queueES
	 */
	public static BlockingQueue<ObjectModelOfRedis> getQueueES() {
		return queueES;
	}
	/**
	 * @param queueES the queueES to set
	 */
	public static void setQueueES(BlockingQueue<ObjectModelOfRedis> queueES) {
		publicStaticMap.queueES = queueES;
	}
	public  static  Map<String,Map<String, Pair>> getCans()
	{
		return values;
	}
	public static void setCans(Map<String,Map<String, Pair>> canIn)
	{
		values=canIn;
	}	
	//存储修改redis的值
	public static BlockingQueue<ObjectModelOfRedis> getRedisValuesQueue()
	{
		return redisQueue;
	}
	
	public static BlockingQueue<byte[]> getMessageQueue()
	{
		return messageQueue;
	}
	public static  Map<String,String > getVehicle()
	{
		return vehicles;
	}
	
	public static void setVehicles( Map<String,String > vehiclesIn)
	{
		vehicles=vehiclesIn;
	}
	
	public static  BlockingQueue<ObjectModelOfKafka> getQueue()
	{
		return queue;
	}
	
	
	
	

}
