package com.wlwltech.pages;

import java.util.HashMap;
import java.util.List;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wlwltech.redis.update.model.VehicleIndex;

import simplekafka08.simplekafka08.SaveDataToES;

public class SubmitIndex implements Runnable {

	private String tableName;
	private String type;
	private List<VehicleIndex> vehicles;
	private static final Logger logger = LoggerFactory.getLogger(SubmitIndex.class);

	public SubmitIndex(String intabeleName, String intype, List<VehicleIndex> invehicles) {
		this.tableName = intabeleName;
		this.type = intype;
		this.vehicles = invehicles;

	}

	@Override
	public void run() {
		//logger.error("数据插入02");
		try {

			 long start = System.currentTimeMillis();
		//	logger.error("开始提交");
			BulkRequestBuilder bulkRequest = EsutilSingle.getClient().prepareBulk();
			//logger.error("开始提交01");
			for (VehicleIndex vehicle : vehicles) {
				HashMap<String, Object> hashMap = new HashMap<String, Object>();
				hashMap.put("status", vehicle.getOnLine());
				hashMap.put("location", vehicle.getLocation());
				hashMap.put("time", vehicle.getTime());
				bulkRequest.add(EsutilSingle.getClient().prepareIndex(tableName, type)
						.setId(vehicle.getVehicleUnid() + "-" + vehicle.getTime()).setSource(hashMap));

			}
			//logger.error("开始提交02");
			bulkRequest.execute().actionGet();
			//logger.error("开始提交03");
			 System.out.println("完成时间" + (System.currentTimeMillis() -
			 start));
			//logger.error("开始结束");
		} catch (Exception ex) {
			logger.error("插入所有错误", ex);

		}
	}

}
