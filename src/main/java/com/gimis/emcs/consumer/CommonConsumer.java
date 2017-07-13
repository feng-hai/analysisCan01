package com.gimis.emcs.consumer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.utils.VerifiableProperties;

import com.gimis.emcs.ps.msg.Message;
import com.gimis.emcs.thread.CanAlarmFaultThread;
import com.gimis.emcs.thread.GPSThread;
import com.gimis.emcs.thread.McuCanDataPassThread;
import com.gimis.emcs.util.LogUtil;
import com.gimis.emcs.util.MessageDecoder;

public class CommonConsumer{
	
	private String topic;

	private ConsumerConfig config;
	
	private ConsumerConnector connector;
	
	public CommonConsumer(String topic)
	{
		this.topic = topic;
		
		Properties prop = new Properties();
//		prop.put("zookeeper.connect", "GMSBDDN1:2181,GMSBDDN2:2181,GMSBDDN3:2181");
//		prop.put("group.id", "faultConsumer3");
//		prop.put("auto.commit.enable", "true");
//		prop.put("zookeeper.session.timeout.ms","20000");
//		prop.put("zookeeper.sync.time.ms", "200");
//		prop.put("auto.commit.interval.ms", "1000");
//		prop.put("rebalance.max.retries", "10");
//		prop.put("rebalance.backoff.ms","2500");
		try
        {
            prop.load(this.getClass().getClassLoader().getResourceAsStream("kafka.properties"));
        }
        catch (IOException e)
        {
           LogUtil.getLogger(this).error("加载Kafka配置文件异常",e);
        }
		
		config = new ConsumerConfig(prop);
	}
	
	public void startListener()
	{
	    LogUtil.getLogger(this).error("开始启动Kafka消费者 : " + topic);
		connector = Consumer.createJavaConsumerConnector(config);
		
		Map<String,Integer> topics = new HashMap<String,Integer>();
		
		topics.put(topic, 1);
		
		Map<String,List<KafkaStream<String,Message>>> streams = connector.createMessageStreams(topics,
                new MessageDecoder<String>(new VerifiableProperties()), new MessageDecoder<Message>(new VerifiableProperties()));
        List<KafkaStream<String, Message>> partitions = streams.get(topic);
        
        for(KafkaStream<String,Message> partition : partitions)
        {
        	new CanAlarmFaultThread(partition).start();
        	
        	//new GPSThread(partition).start();
        	
        	//new McuCanDataPassThread(partition).start();
        }
        LogUtil.getLogger(this).error("启动消费者完成.......");
	}
	
	public void shutdown()
	{
		if(null != connector)
		{
			connector.shutdown();
		}
	}
}
