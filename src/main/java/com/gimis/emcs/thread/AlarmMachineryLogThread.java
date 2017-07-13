package com.gimis.emcs.thread;

import java.util.List;

import com.gimis.emcs.domain.AlarmMachinery;
import com.gimis.emcs.queue.GlobalQueue;
import com.gimis.emcs.service.AlarmMachineryLogService;
import com.gimis.emcs.service.impl.AlarmMachineryLogServiceImpl;
import com.gimis.emcs.util.LogUtil;

public class AlarmMachineryLogThread extends Thread {

		private GlobalQueue globalQueue;
		
		private AlarmMachineryLogService alarmMachineryLogService;
		
		public AlarmMachineryLogThread()
		{
			globalQueue = GlobalQueue.getInstance();
			alarmMachineryLogService = new AlarmMachineryLogServiceImpl();
		}

		@Override
		public void run() {
		    LogUtil.getLogger(this).warn("启动历史报警持久化线程.........");
			while(true)
			{
				try
				{
					List<AlarmMachinery> alarmLogList = globalQueue.getLogAlarmList();
					
					if(null == alarmLogList || alarmLogList.size() == 0)
					{
						sleep(10000);
						continue;
					}
					alarmMachineryLogService.updateAlarmEnd(alarmLogList);
					sleep(60000);
				}
				catch(Exception e)
				{
					LogUtil.getLogger(this).error("更新历史报警异常",e);
				}
				
			}
		}
		

	
	
}
