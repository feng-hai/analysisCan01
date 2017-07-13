package com.gimis.emcs.thread;

import java.util.List;

import com.gimis.emcs.domain.FaultMachinery;
import com.gimis.emcs.queue.GlobalQueue;
import com.gimis.emcs.service.FaultMachineryLogService;
import com.gimis.emcs.service.impl.FaultMachineryLogServiceImpl;
import com.gimis.emcs.util.LogUtil;

public class FaultMachineryLogThread extends Thread {

		private GlobalQueue globalQueue;
		
		private FaultMachineryLogService faultMachineryLogService;
		
		public FaultMachineryLogThread()
		{
			globalQueue = GlobalQueue.getInstance();
			faultMachineryLogService = new FaultMachineryLogServiceImpl();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
		    LogUtil.getLogger(this).warn("启动历史故障持久化线程.........");
		
			while(true)
			{
				try
				{
					List<FaultMachinery> fmLogList = globalQueue.getLogFaultList();
					
					if(null == fmLogList || fmLogList.size() == 0)
					{
						sleep(1000);
						continue;
					}
					
					faultMachineryLogService.updateAlarmEnd(fmLogList);
					
					sleep(60000*3);
					
				}
				catch(Exception e)
				{
					LogUtil.getLogger(this).error("更新历史故障异常",e);
				}
				
			}
		}
		

	
	
}
