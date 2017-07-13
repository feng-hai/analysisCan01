package com.gimis.emcs.thread;

import java.util.List;

import com.gimis.emcs.domain.FaultMachinery;
import com.gimis.emcs.queue.GlobalQueue;
import com.gimis.emcs.service.FaultMachineryLogService;
import com.gimis.emcs.service.impl.FaultMachineryLogServiceImpl;
import com.gimis.emcs.util.LogUtil;

/**
 * 当前车辆故障存储线程
* [一句话功能简述]<p>
* [功能详细描述]<p>
* @author yanshuai
* @version 1.0, 2016年11月29日

* @since V1.0
 */
public class FaultMachineryCurrentThread extends Thread{
	
	private GlobalQueue globalQueue;
	
	private FaultMachineryLogService faultMachineryLogService;
	
	public FaultMachineryCurrentThread()
	{
		globalQueue = GlobalQueue.getInstance();
		faultMachineryLogService = new FaultMachineryLogServiceImpl();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	    LogUtil.getLogger(this).warn("启动当前故障持久化线程.........");
		while(true)
		{
			try{
				
				List<FaultMachinery> currentFaultList = globalQueue.getCurrentFaultList();
				//批量更新
				faultMachineryLogService.add(currentFaultList);
				
			}catch(Exception e)
			{
			    LogUtil.getLogger(this).error("持久化当前故障异常",e);
			}
		}
	}
	
	
	
}
