package com.wlwltech.csrzic.redis;

import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class ReadRedisThread extends Thread {

	public BlockingQueue<Map<String, Object>> _obj;
	public List<String> _vehicle;

	public ReadRedisThread(BlockingQueue<Map<String, Object>> obj, List<String> vehicle) {
		this._obj = obj;
	}

	public void run() {
		while (true) {
			try {
				Map<String, Object> message=null;
				synchronized (this._obj) {
					 message = this._obj.take();
				}
				
				List<String> test = RedisPool.getInstance().getJedisCluster()
						.hmget("mach#1002:" + message.get("ID"), "vin", "id");
				//this._vehicle.add();
				if (this._obj.size() == 0) {
					break;
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
