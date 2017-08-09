package simplekafka08.simplekafka08;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wlwltech.csrzic.redis.PropertyResource;

public class MyConsumer {
	private static final Logger LOG = LoggerFactory.getLogger(MyConsumer.class);
	public static void main(String[] args) {
		
		HashMap<String, String> prop = PropertyResource.getInstance().getProperties();

		try {
			String path = new File(".").getCanonicalPath() + "/resource/log4j.properties";
			PropertyConfigurator.configure(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		// TODO Auto-generated method stub
		Properties props = new Properties();
		// props.put("bootstrap.servers",
		// "namenode.cube:9092,datanode1.cube:9092,hyperrouter1.cube:9092,hyperrouter2.cube:9092");
		props.put("bootstrap.servers", prop.get("kafka.server"));
		props.put("group.id", prop.get("kafka.groupId"));
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		List<String> topicList = new ArrayList<String>();
		topicList.add(prop.get("kafka.topicName.canData"));
		consumer.subscribe(topicList);

		while (true) {
			try {
				System.out.println("开始获取数据信息");
				ConsumerRecords<String, String> records = consumer.poll(1000);
				
				System.out.println("数据获取"+records.count());
				for (ConsumerRecord<String, String> record : records)
				{
					System.out.printf("offset = %d, key = %s, value = %s\r\n", record.offset(), record.key(),
							record.value());
				}
				
			} catch (Exception ex) {
				LOG.error("报错",ex);
//				consumer.close();
//				consumer = new KafkaConsumer<String, String>(props);
//				topicList = new ArrayList<String>();
//				topicList.add(prop.get("kafka.topicName.canData"));
//				consumer.subscribe(topicList);
			}
		}

	}

}
