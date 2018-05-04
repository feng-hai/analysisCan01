package simplekafka08.simplekafka08;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wlwltech.csrzic.redis.PropertyResource;
import com.wlwltech.redis.update.model.Pair;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

/**
 * 详细可以参考：https://cwiki.apache.org/confluence/display/KAFKA/Consumer+Group+
 * Example
 * 
 * @author Fung
 *
 */
public class ConsumerDemo {
	private final ConsumerConnector consumer;
	private final String topic;
	private ExecutorService executor;
	private static final Logger LOG = LoggerFactory.getLogger(ConsumerDemo.class);

	public ConsumerDemo(String a_zookeeper, String a_groupId, String a_topic) {
		consumer = Consumer.createJavaConsumerConnector(createConsumerConfig(a_zookeeper, a_groupId));
		this.topic = a_topic;
	}

	public void shutdown() {
		if (consumer != null)
			consumer.shutdown();
		if (executor != null)
			executor.shutdown();
	}

	public void run(int numThreads) {
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		topicCountMap.put(topic, new Integer(numThreads));
		Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
		List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);

		// now launch all the threads
		executor = Executors.newFixedThreadPool(numThreads);

		// now create an object to consume the messages
		//
		int threadNumber = 0;
		for (final KafkaStream stream : streams) {

			executor.submit(new ConsumerMsgTask(stream, threadNumber));
			threadNumber++;
		}
	}

	private static ConsumerConfig createConsumerConfig(String a_zookeeper, String a_groupId) {
		Properties props = new Properties();
		props.put("zookeeper.connect", a_zookeeper);
		props.put("group.id", a_groupId);
		props.put("zookeeper.session.timeout.ms", "400");
		props.put("zookeeper.sync.time.ms", "200");
		props.put("auto.commit.interval.ms", "1000");
		// props.put("socket.receive.buffer.bytes", 1024*1024 );
		return new ConsumerConfig(props);
	}

	public static void main(String[] arg) {

		HashMap<String, String> prop = PropertyResource.getInstance().getProperties();

		try {
			String path = new File(".").getCanonicalPath() + "/resource/log4j.properties";
			PropertyConfigurator.configure(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/// PropertyConfigurator.configure("source/log4j.properties");//GBTrans
		/// canData-total-1002
		// String[] args = { "GMSBDDN1:2181,GMSBDDN2:2181,GMSBDDN3:2181",
		/// "group-1", "canData-1002", "12" };
		// String[] args = {
		// "ZS0114PDNEV01:2181,ZS0114VYZTEV7:2181,ZS0114VYZTEV8:2181",
		// "group-1", "canData-total-1002", "30" };
		// String zooKeeper = args[0];
		// String groupId = args[1];
		// String topic = args[2];
		int threads = Integer.parseInt(prop.get("kafka.ThreadNum"));

		// int threads = Integer.parseInt(prop.get("kafka.ThreadNum"));
		// System.out.println(prop.get("kafka.ThreadNum"));
		// System.out.println(prop.get("kafka.server"));
		// System.out.println(prop.get("kafka.topicName.canData"));
		// System.out.println(prop.get("kafka.groupId"));

		// 定期获取车辆信息的，定时器
		Timer timer = new Timer();
		timer.schedule(new MyTask(), new Date(), 300000);

		// 更新车辆状态
		// Timer timerOnLine = new Timer();
		// timerOnLine.schedule(new MyTaskOnLine(), new Date(), 120000);
		//
		// for (int i = 0; i < 6; i++) {
		//更新kafka
//		SendDataTokafka sendDataKafka = new SendDataTokafka();
//		sendDataKafka.setDaemon(true);
//		sendDataKafka.start();
		// }
		//更新redis
		SaveDataToES sendDataES = new SaveDataToES();
		sendDataES.setDaemon(true);
		sendDataES.start();
		
		HandleThreadForStatus updateStatus = new HandleThreadForStatus();
		updateStatus.setDaemon(true);
		updateStatus.start();
		
		
		
		// for (int i = 0; i < 3; i++) {
		SaveDataRedis sendData = new SaveDataRedis();
		sendData.setDaemon(true);
		sendData.start();
		// }
		// SaveDataRedis sendData = new SaveDataRedis();
		// sendData.setDaemon(true);
		// sendData.start();
		ConsumerDemo mcu = new ConsumerDemo(prop.get("kafka.server"), prop.get("kafka.groupId"),
				prop.get("kafka.topicName.canData"));
		mcu.run(threads);
		//
		// ConsumerDemo gps = new ConsumerDemo(prop.get("kafka.server"),
		// prop.get("kafka.groupId"),
		// prop.get("kafka.topicName.gpsData"));
		// gps.run(threads);

		// demo.shutdown();

	}
}