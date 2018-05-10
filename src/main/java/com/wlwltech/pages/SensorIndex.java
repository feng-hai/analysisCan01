package com.wlwltech.pages;

import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wlwltech.redis.update.model.VehicleIndex;

import simplekafka08.simplekafka08.SaveDataRedis;

public class SensorIndex {
	private static CopyOnWriteArrayList<VehicleIndex> vehiclesIndex = new CopyOnWriteArrayList<>();
	private static final Logger logger = LoggerFactory.getLogger(SensorIndex.class);
	// private static int threadNum = Integer
	// .parseInt(PropertyResource.getInstance().getProperties().get("indexHistoryThreadNum"));
//	private static ExecutorService executor;
//
//	static {
//		executor = Executors.newFixedThreadPool(5);
//	}

	public synchronized  void setValue(VehicleIndex vi, String tableName) {

		// logger.error("开始插入");
		vehiclesIndex.add(vi);
		if (vehiclesIndex.size() > 200) {
			// logger.error("开始插入01");
			// executor.submit(
			new SubmitIndex(tableName, "vehicle", vehiclesIndex).run();
			// );
			;
			vehiclesIndex.clear();
		}

	}
}
