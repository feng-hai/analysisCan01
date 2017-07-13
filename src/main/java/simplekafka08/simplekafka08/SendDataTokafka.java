package simplekafka08.simplekafka08;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wlwltech.redis.update.model.JsonUtils;
import com.wlwltech.redis.update.model.ObjectModelOfKafka;
import com.wlwltech.redis.update.model.Pair;

import kafka.common.Config;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class SendDataTokafka extends Thread {

	private Producer<String, String> producer;

	private Config config;

	private static final Logger logger = LoggerFactory.getLogger(SendDataTokafka.class);

	public SendDataTokafka() {

		initKafka();

	}

	private void initKafka() {

		// Properties props = new Properties();
		// props.put("bootstrap.servers", "");
		// props.put("acks", "1");
		// props.put("retries", 0);
		// props.put("batch.size", 16384);
		// props.put("linger.ms", 1);
		// props.put("buffer.memory", 33554432);
		// props.put("key.serializer",
		// "org.apache.kafka.common.serialization.StringSerializer");
		// props.put("value.serializer",
		// "org.apache.kafka.common.serialization.StringSerializer");
		// // producer = new KafkaProducer<String, String>(props);
		// 设置配置属性
		Properties props = new Properties();
		// props.put("metadata.broker.list","GMSBDDN1:9092,GMSBDDN2:9092,GMSBDDN3:9092");
		props.put("metadata.broker.list", "ZS0114PDNEV01:9092,ZS0114PDNEV02:9092,ZS0114PDNEV03:9092");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		// key.serializer.class默认为serializer.class
		props.put("key.serializer.class", "kafka.serializer.StringEncoder");
		// 可选配置，如果不配置，则使用默认的partitioner
		props.put("partitioner.class", "simplekafka08.simplekafka08.PartitionerDemo");
		// 触发acknowledgement机制，否则是fire and forget，可能会引起数据丢失
		// 值为0,1,-1,可以参考
		// http://kafka.apache.org/08/configuration.html
		props.put("request.required.acks", "1");
		ProducerConfig config = new ProducerConfig(props);

		// 创建producer
		producer = new Producer<String, String>(config);

	}

	public void run() {
		while (true) {

			try {
				
				ObjectModelOfKafka message = publicStaticMap.getQueue().take();
				KeyedMessage<String, String> data = new KeyedMessage<String, String>("canData-total-1002",
						message.getMachineryId(), JsonUtils.serialize(message));
				producer.send(data);
				
				logger.info("S"+message.getMachineryId() + "-" + message.getDATIME_RX() + "-"
						+ publicStaticMap.getQueue().size() + "-" + getAllMile(message.getPairs()).getValue() + "-"
						+ getSOC(message.getPairs()).getValue());

			} catch (Exception e) {
				e.printStackTrace();
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
