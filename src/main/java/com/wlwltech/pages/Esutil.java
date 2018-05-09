package com.wlwltech.pages;

import java.net.InetAddress;

import java.util.List;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wlwltech.redis.update.model.VehicleIndex;

public class Esutil {
	public static TransportClient client = null;

	private static final Logger logger = LoggerFactory.getLogger(Esutil.class);

	private static int max = 1;

	@SuppressWarnings("resource")
	public static TransportClient getClient() {
		if (client != null) {
			return client;
		}
		Settings settings = Settings.builder().put("cluster.name", "Heracles")// 集群名称
				.put("client.transport.sniff", true)// 自动嗅探整个ES集群节点
				.put("transport.type", "netty3").put("http.type", "netty3")
				.build();//// 每5秒提交一次数据，类似oracle中的commit

		try {
			// client = new PreBuiltTransportClient(settings);
			// String servers =
			// PropertyResource.getInstance().getProperties().get("index.server");
			// String[] serverIndex = servers.split(",");
			// for (String index : serverIndex) {
			//
			// client.addTransportAddress(new
			// InetSocketTransportAddress(InetAddress.getByName(index), 9300));
			// }
			client = new PreBuiltTransportClient(settings)
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.21.9"), 9300))
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.21.10"), 9300))
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.21.11"), 9300))
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.21.12"), 9300))
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.21.13"), 9300));
		} catch (Exception e) {
			// e.printStackTrac();
			logger.error("连接索引错误", e);
		}
		return client;
	}

	/**
	 * @Title: addIndex 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param 
	 * @param index
	 *         表名 小写 
	 * @param 
	 * @param type ”vehicle“ @param @param vehicles
	 *         设定文件 @return void 返回类型 @throws
	 */
	public static void addIndex(String index, String type, List<VehicleIndex> vehicles) {
		try {

			//long start = System.currentTimeMillis();
			logger.error("开始提交");
//			BulkRequestBuilder bulkRequest = getClient().prepareBulk();
//
//			for (VehicleIndex vehicle : vehicles) {
//				HashMap<String, Object> hashMap = new HashMap<String, Object>();
//				hashMap.put("status", vehicle.getOnLine());
//				hashMap.put("location", vehicle.getLocation());
//				hashMap.put("time", vehicle.getTime());
//				bulkRequest.add(getClient().prepareIndex(index, type)
//						.setId(vehicle.getVehicleUnid() + "-" + vehicle.getTime()).setSource(hashMap));
//				if (max++ > 1000)
//					;
//				{
//					bulkRequest.execute().actionGet();
//					max = 1;
//				}
//			}
//			max = 1;
//			bulkRequest.execute().actionGet();
			//System.out.println("完成时间" + (System.currentTimeMillis() - start));
			logger.error("开始结束" + max);
		} catch (Exception ex) {
			logger.error("插入所有错误", ex);
			client = null;
		}
	}
}
