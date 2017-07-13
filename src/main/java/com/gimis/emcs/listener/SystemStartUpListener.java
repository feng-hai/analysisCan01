package com.gimis.emcs.listener;

import com.gimis.emcs.consumer.CommonConsumer;
import com.gimis.emcs.thread.AlarmMachineryCurrentThread;
import com.gimis.emcs.thread.AlarmMachineryLogThread;
import com.gimis.emcs.thread.FaultMachineryCurrentThread;
import com.gimis.emcs.thread.FaultMachineryLogThread;
import com.gimis.emcs.util.LogUtil;

public class SystemStartUpListener implements Runnable {

	public void run() {
	    LogUtil.getLogger(this).warn("开始启动系统监听类");
		// 启动kafka消费者  topicName:canAlarmState-1002  gpsData-1016    canData-1016
		CommonConsumer consumer = new CommonConsumer("canAlarmState-1016");
		consumer.startListener();
		// 启动故障报警持久化线程
		new FaultMachineryCurrentThread().start();
		new FaultMachineryLogThread().start();
		new AlarmMachineryCurrentThread().start();
		new AlarmMachineryLogThread().start();
		LogUtil.getLogger(this).warn("启动系统监听类完成");
	}
}
