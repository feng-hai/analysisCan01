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

	public SaveDataRedis() {

	}

	@SuppressWarnings("resource")
	public void run() {
		long s = System.currentTimeMillis();
		long refresh = System.currentTimeMillis();
		JedisClusterPipeline jcp = JedisClusterPipeline.pipelined(RedisPool.getInstance().getJedisCluster());
		jcp.refreshCluster();
		while (true) {

			try {

				ObjectModelOfRedis message = publicStaticMap.getRedisValuesQueue().take();
				jcp.hmset("mach:" + message.getKey(), message.getRedisValues());
				// RedisPool.getInstance().getJedisCluster().hmset("mach:"
				// +message.getKey(), message.getRedisValues());

				logger.info("K" + message.getKey() +"-"+ publicStaticMap.getMessageQueue().size()+"-" + publicStaticMap.getRedisValuesQueue().size() + "-"
						+ message.getRedisValues().get("lastLocateTime") + ":"
						+ message.getRedisValues().get("lastCanTime")+":"+ message.getRedisValues().get("lastCanTime"));

				long t = System.currentTimeMillis() - s;
				if (t >= 1000) {
					jcp.sync();
					s = System.currentTimeMillis();
				}

			} catch (Exception e) {
				e.printStackTrace();
				jcp = JedisClusterPipeline.pipelined(RedisPool.getInstance().getJedisCluster());
				jcp.refreshCluster();
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
