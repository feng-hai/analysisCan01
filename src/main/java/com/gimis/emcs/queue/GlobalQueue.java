package com.gimis.emcs.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.gimis.emcs.domain.AlarmMachinery;
import com.gimis.emcs.domain.FaultMachinery;


public class GlobalQueue {
	
	private static final GlobalQueue instance = new GlobalQueue();
	
	private GlobalQueue()
	{
		
	}

	public static GlobalQueue getInstance()
	{
		return instance;
	}
	
	/**
	 * 当前故障列表(只有报警开始时间)
	 */
	private final BlockingQueue<FaultMachinery> faultCurrentQueue = new ArrayBlockingQueue<FaultMachinery>(20000);
//	private final List<FaultMachinery> faultCurrentList = Collections.synchronizedList(new ArrayList<FaultMachinery>());
	
	/**
	 * 历史故障列表(有报警结束时间)
	 */
	private final List<FaultMachinery> faultLogList = Collections.synchronizedList(new ArrayList<FaultMachinery>());
	
	/**
	 * 当前报警列表(只有开始时间)
	 */
	private final BlockingQueue<AlarmMachinery> alarmCurrentQueue = new ArrayBlockingQueue<AlarmMachinery>(20000);
//	private final List<AlarmMachinery> alarmCurrentList = Collections.synchronizedList(new ArrayList<AlarmMachinery>());
	
	/**
	 * 历史报警列表(有结束时间)
	 */
	private final List<AlarmMachinery> alarmLogList = Collections.synchronizedList(new ArrayList<AlarmMachinery>());
	
	/**
	 * 添加当前故障
	 * @param fm
	 */
	public void addCurrentFault(FaultMachinery fm)
	{
		if(faultCurrentQueue.size() > 6000)
		{
			faultCurrentQueue.poll();
		}
		faultCurrentQueue.add(fm);
		
	}
	
	/**
	 * 获取当前故障列表，并将故障列表清除
	 * @return
	 */
	public List<FaultMachinery> getCurrentFaultList()
	{
		List<FaultMachinery> resList = new ArrayList<FaultMachinery>();
		
		try {
		    
			if(faultCurrentQueue.size() > 200)
			{
			    //批量插入，一次插入200条数据
				for(int i = 0 ; i< 200;i++)
				{
					resList.add(faultCurrentQueue.take());
				}
			}
			else
			{
				int realSize = faultCurrentQueue.size();
				for(int i = 0 ; i<realSize;i++)
				{
					resList.add(faultCurrentQueue.take());
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resList;
	}
	
	public void addLogFault(FaultMachinery fm)
	{
		faultLogList.add(fm);
		if(faultLogList.size() > 500)
		{
			faultLogList.remove(0);
		}
	}
	
	public List<FaultMachinery> getLogFaultList()
	{
		List<FaultMachinery> returnList = new ArrayList<FaultMachinery>(faultLogList);
		faultLogList.clear();
		return returnList;
	}
	
	public void addCurrentAlarm(AlarmMachinery am)
	{
		alarmCurrentQueue.add(am);
		if(alarmCurrentQueue.size() > 6000)
		{
			alarmCurrentQueue.poll();
		}
	}
	
	public AlarmMachinery getCurrentAlarm()
	{
		try {
			return alarmCurrentQueue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addLogAlarm(AlarmMachinery am)
	{
		alarmLogList.add(am);
	}
	
	public List<AlarmMachinery> getLogAlarmList()
	{
		List<AlarmMachinery> retList = new ArrayList<AlarmMachinery>(alarmLogList);
		alarmLogList.clear();
		return retList;	
	}
}
