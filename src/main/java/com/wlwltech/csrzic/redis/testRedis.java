package com.wlwltech.csrzic.redis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


import com.wlwl.mysql.JdbcUtils;
import com.wlwl.mysql.SingletonJDBC;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class testRedis {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		// 获取所以分布式节点
		// TreeSet<String> keys = new TreeSet<String>();
		// Map<String, JedisPool> clusterNodes =
		// RedisPool.getInstance().getJedisCluster().getClusterNodes();
		// for(String k : clusterNodes.keySet()){
		// //logger.debug("Getting keys from: {}", k);
		// JedisPool jp = clusterNodes.get(k);
		// Jedis connection = jp.getResource();
		// try {
		// keys.addAll(connection.keys("mach#1002:*"));
		// } catch(Exception e){
		// // logger.error("Getting keys error: {}", e);
		// } finally{
		// // logger.debug("Connection closed.");
		// connection.close();//用完一定要close这个链接！！！
		// }
		// }

		BlockingQueue<Map<String, Object>> sendQueue = new LinkedBlockingQueue<Map<String, Object>>();
		JdbcUtils utils = SingletonJDBC.getJDBC();
		List<Object> params = new ArrayList<Object>();
		params.add(5);
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			result = utils.findModeResult("select distinct vehi.id from emcs_csrzic.sys_user su "
					+ "inner join  emcs_csrzic.sys_user_data_role   sudr   on su.id =sudr.user_id  and su.id=? "
					+ "inner join emcs_csrzic.sys_data_right_relation  rel  on (sudr.DATA_ROLE_ID=rel.owner_id and rel.data_relation_type=1 ) or "
					+ "(su.id=rel.owner_id and rel.data_relation_type=2) "
					+ "inner  join emcs_csrzic.vehicle_device vehi  "
					+ " on( rel.data_id!=-1 and ((vehi.MANUFACTURERS_ID=rel.Data_id and rel.data_type_id=1 ) "
					+ " or (vehi.MACHINERY_TYPE_ID=rel.Data_id and rel.data_type_id=2 )"
					+ " or (vehi.MODEL_ID =rel.Data_id and rel.data_type_id=3 ) "
					+ " or (vehi.DISTRIBUTOR_ID=rel.Data_id and rel.data_type_id=4) "
					+ " or (vehi.AFTER_SALE_ID=rel.Data_id and rel.data_type_id=5) "
					+ " or (vehi.MODEL_ID=rel.Data_id and rel.data_type_id=6) "
					+ " or (vehi.CLIENT_ID=rel.Data_id and rel.data_type_id=7) "
					+ " or (vehi.EQUIPMENT_STATE=rel.Data_id and rel.data_type_id=8) "
					+ " or (vehi.GPS_MANUFACTURER_ID=rel.Data_id and rel.data_type_id=9) "
					+ " or (vehi.BUS_COMPANY_ID=rel.Data_id and rel.data_type_id=10) "
					+ " or (vehi.BUS_LINE_ID=rel.Data_id and rel.data_type_id=11))) or ("
					+ " rel.data_id=-1 and ((vehi.MANUFACTURERS_ID is not null  and rel.data_type_id=1 ) "
					+ " or (vehi.MACHINERY_TYPE_ID is not null  and rel.data_type_id=2 ) "
					+ " or (vehi.MODEL_ID  is not null and rel.data_type_id=3 ) "
					+ " or (vehi.DISTRIBUTOR_ID is not null  and rel.data_type_id=4) "
					+ " or (vehi.AFTER_SALE_ID is not null  and rel.data_type_id=5) "
					+ " or (vehi.MODEL_ID is not null  and rel.data_type_id=6) "
					+ " or (vehi.CLIENT_ID is not null  and rel.data_type_id=7) "
					+ " or (vehi.EQUIPMENT_STATE is not null and rel.data_type_id=8) "
					+ " or (vehi.GPS_MANUFACTURER_ID is not null and rel.data_type_id=9) "
					+ " or (vehi.BUS_COMPANY_ID  is not null and rel.data_type_id=10) "
					+ " or (vehi.BUS_LINE_ID is not null and rel.data_type_id=11)))", params);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int nums=0;
		while (nums<1000)
		{
		Long start = System.currentTimeMillis();

		for (Map<String, Object> idO : result) {
			sendQueue.add(idO);

		}
		List<String> temp = new ArrayList<String>();
		for (int i = 0; i < 30; i++) {
			// // 发送命令---从数据队列中获取数据，并把数据发送出去
			ReadRedisThread sendCommmandThread = new ReadRedisThread(sendQueue, temp);
			sendCommmandThread.setDaemon(true);
			sendCommmandThread.start();
		}
		
		while (true) {
			if (sendQueue.size() == 0) {
				Long num = System.currentTimeMillis() - start;
				System.out.println(num);
				break;
			} else {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nums++;
		}

		
		// logger.debug("Keys gotten!");

		// List<String>
		// test=RedisPool.getInstance().getJedisCluster().hmget("mach#1002:1","vin","id");
		// Long num =System.currentTimeMillis()-start;


	}

}
