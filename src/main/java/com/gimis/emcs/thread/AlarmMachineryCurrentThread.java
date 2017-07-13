package com.gimis.emcs.thread;

import com.gimis.emcs.domain.AlarmMachinery;
import com.gimis.emcs.queue.GlobalQueue;
import com.gimis.emcs.service.AlarmMachineryLogService;
import com.gimis.emcs.service.impl.AlarmMachineryLogServiceImpl;
import com.gimis.emcs.util.LogUtil;

/**
 * 当前报警持久化线程
* [一句话功能简述]<p>
* [功能详细描述]<p>
* @author yanshuai
* @version 1.0, 2016年11月28日

* @since V1.0
 */
public class AlarmMachineryCurrentThread extends Thread {

		private GlobalQueue globalQueue;
		
		private AlarmMachineryLogService alarmMachineryLogService;
		
		public AlarmMachineryCurrentThread()
		{
			globalQueue = GlobalQueue.getInstance();
			alarmMachineryLogService = new AlarmMachineryLogServiceImpl();
		}

		@Override
		public void run() {
		    LogUtil.getLogger(this).warn("启动当前报警持久化线程.........");
			while(true)
			{
				try
				{
					AlarmMachinery alarmCurrent= globalQueue.getCurrentAlarm();
					
					alarmMachineryLogService.add(alarmCurrent);
				}
				catch(Exception e)
				{
				    LogUtil.getLogger(this).error("持久化当前报警异常",e);
				}
				
			}
		}
		

	
	
}
