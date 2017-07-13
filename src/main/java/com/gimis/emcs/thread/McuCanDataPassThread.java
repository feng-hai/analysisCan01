package com.gimis.emcs.thread;

import java.util.List;

import com.gimis.emcs.ps.msg.Message;
import com.gimis.emcs.ps.msg.mcubody.impl.BaseMcuCanDataPass;
import com.gimis.emcs.ps.msg.vo.CanDataVo;
import com.gimis.emcs.util.LogUtil;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;

public class McuCanDataPassThread extends Thread {
	private KafkaStream<String,Message> partition;
	public McuCanDataPassThread( KafkaStream<String,Message> _partition)
	{
		 this.partition=_partition;
	}
	@Override
	public void run() {
		ConsumerIterator<String, Message> it = partition.iterator();
		while(it.hasNext())
		{
			try
			{
				MessageAndMetadata<String, Message> item = it.next();
				
				Message message = item.message();
				
				if (null == message || null == message.getAppend() || null == message.getMcuBody())
		        {
		            return;
		        }
				Integer machineryId = message.getAppend().getMachineryId();
				
		        BaseMcuCanDataPass mcuBody = (BaseMcuCanDataPass) message.getMcuBody();
		        
		        List<CanDataVo> cans = mcuBody.getCanDataFrame();

			}catch(Exception e)
			{
				LogUtil.getLogger(this).warn("获取kafka消息异常!",e);
			}
		}
		
	}

}
