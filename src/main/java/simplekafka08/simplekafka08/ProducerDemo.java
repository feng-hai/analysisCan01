package simplekafka08.simplekafka08;

import java.util.Collections;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * 详细可以参考：https://cwiki.apache.org/confluence/display/KAFKA/0.8.0+Producer+Example
 * @author Fung
 *
 */
public class ProducerDemo {
	public static void main(String[] args) {
		Random rnd = new Random();
		int events=10000;

		// 设置配置属性
		Properties props = new Properties();
		props.put("metadata.broker.list","GMSBDDN1:9092,GMSBDDN2:9092,,GMSBDDN3:9092");
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
		Producer<String, String> producer = new Producer<String, String>(config);
		// 产生并发送消息
		long start=System.currentTimeMillis();
		for (long i = 0; i < events; i++) {
			long runtime = new Date().getTime();
			String ip = "192.178.29."+ i;//rnd.nextInt(255);
			String msg = "测试数据"+"www.newnetcom.com"+ip;
			//如果topic不存在，则会自动创建，默认replication-factor为1，partitions为0
			KeyedMessage<String, String> data = new KeyedMessage<String, String>(
					"canData-1002", ip, msg);
			producer.send(data);
		}
		System.out.println("耗时:" + (System.currentTimeMillis() - start));
		// 关闭producer
		producer.close();
	}
}