package simplekafka08.simplekafka08;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wlwltech.csrzic.redis.JedisClusterPipeline;
import com.wlwltech.csrzic.redis.RedisPool;
import com.wlwltech.redis.update.model.JsonUtils;
import com.wlwltech.redis.update.model.ObjectModelOfKafka;
import com.wlwltech.redis.update.model.ObjectModelOfRedis;
import com.wlwltech.redis.update.model.Pair;

import kafka.common.Config;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class SaveDataRedis extends Thread {

	private Producer<String, String> producer;

	private Config config;
	private static final Logger logger = LoggerFactory.getLogger(SaveDataRedis.class);
	long refresh = System.currentTimeMillis();

	//
	public SaveDataRedis() {

	}

	@SuppressWarnings("resource")
	public void run() {
		JedisClusterPipeline jcp = JedisClusterPipeline.pipelined(RedisPool.getInstance().getJedisCluster());
		long s = System.currentTimeMillis();
		long count = 0;
		while (true) {
			try {
				ObjectModelOfRedis message = publicStaticMap.getRedisValuesQueue().take();
				if (publicStaticMap.getRedisValuesQueue().size() > 2000) {
					publicStaticMap.getRedisValuesQueue().clear();
				}
				jcp.hmset("mach:" + message.getKey(), message.getRedisValues());
				// RedisPool.getInstance().getJedisCluster().hmset("mach:"
				// +message.getKey(), message.getRedisValues());

				long t = System.currentTimeMillis() - s;
				if (t >= 10000 || count++ > 500) {
					count = 0;
					jcp.sync();
					s = System.currentTimeMillis();
					long size = publicStaticMap.getRedisValuesQueue().size();
					logger.info("换成中数据大小：" + publicStaticMap.getRedisValuesQueue().size() + "K" + message.getKey() + "-"
							+ publicStaticMap.getMessageQueue().size() + "-" + size + "-"
							+ message.getRedisValues().get("lastLocateTime") + ":"
							+ message.getRedisValues().get("MILEAGE") + ":"
							+ message.getRedisValues().get("lastCanTime"));
					if (size > 2000) {
						publicStaticMap.getRedisValuesQueue().clear();
					}
				}
			} catch (Exception e) {
				logger.error("更新redis失败",e);
				try {
					Thread.sleep(60000);
					jcp.close();

				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception ex) {
					logger.error("关闭jcp失败",ex);
				}
				jcp = null;
				jcp = JedisClusterPipeline.pipelined(RedisPool.getInstance().getJedisCluster());
				jcp.refreshCluster();
				// jcp.refreshCluster();
			}

		}
	}

	public void shutdown() {
		producer.close();
	}

	public Pair getAllMile(List<Pair> pairs) {

		for (Pair p : pairs) {
			if (p.getAlias().equals("MILEAGE")) {
				return p;
			}
		}
		return new Pair();

	}

	public Pair getVoL(List<Pair> pairs) {
		for (Pair p : pairs) {
			if (p.getAlias().equals("VOL_1")) {
				return p;
			}
		}
		return new Pair();

	}

	public Pair getSOC(List<Pair> pairs) {
		for (Pair p : pairs) {
			if (p.getAlias().equals("SOC")) {
				return p;
			}
		}
		return new Pair();

	}

}
