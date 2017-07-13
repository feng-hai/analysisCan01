package com.gimis.emcs.thread;

import java.util.Date;
import java.util.List;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;

import com.gimis.emcs.domain.AlarmDefinition;
import com.gimis.emcs.domain.AlarmMachinery;
import com.gimis.emcs.domain.FaultDefinition;
import com.gimis.emcs.domain.FaultMachinery;
import com.gimis.emcs.domain.util.DateUtil;
import com.gimis.emcs.domain.vo.CanAlarm;
import com.gimis.emcs.domain.vo.MachCache;
import com.gimis.emcs.ps.msg.Message;
import com.gimis.emcs.ps.msg.mcubody.impl.BaseCanAlarmState;
import com.gimis.emcs.ps.msg.vo.CanAlarmVo;
import com.gimis.emcs.queue.GlobalQueue;
import com.gimis.emcs.service.AlarmDefinitionCacheService;
import com.gimis.emcs.service.FaultDefinitionCacheService;
import com.gimis.emcs.service.MachCacheService;
import com.gimis.emcs.service.impl.AlarmDefinitionCacheServiceImpl;
import com.gimis.emcs.service.impl.FaultDefinitionCacheServiceImpl;
import com.gimis.emcs.service.impl.MachCacheServiceImpl;
import com.gimis.emcs.util.LogUtil;

/**
 * 故障报警数据消费处理线程
 * @author lion
 *
 */
public class CanAlarmFaultThread extends Thread {
	
	private MachCacheService machCacheService;
	
	private FaultDefinitionCacheService faultDefinitionCacheService;
	
	private AlarmDefinitionCacheService alarmDefinitionCacheService;
	
	private KafkaStream<String,Message> partition;
	
	private GlobalQueue globalQueue;
	
	public CanAlarmFaultThread(KafkaStream<String,Message> partition)
	{
		this.partition = partition;
		this.faultDefinitionCacheService = new FaultDefinitionCacheServiceImpl();
		this.alarmDefinitionCacheService = new AlarmDefinitionCacheServiceImpl();
		this.machCacheService = new MachCacheServiceImpl();
		this.globalQueue = GlobalQueue.getInstance();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
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
		        if (null == machineryId)
		        {
		            return;
		        }
		        
		        //获取Redis中缓存的关于该车辆的所有故障报警信息
		        MachCache state = machCacheService.queryMachAlarm(machineryId);
		        
		        //Kafka消息传递过来的故障报警信息
		        BaseCanAlarmState alarmState = (BaseCanAlarmState) message.getMcuBody();
		        
		        //处理故障报警信息
		        if (null != state && null != alarmState.getAlarmNum() && alarmState.getAlarmNum() > 0)
		        {
		        	//过滤掉经纬度异常的故障报警
		        	if (alarmState.getLatitude() > 1000 || alarmState.getLatitude() > 1000)
		            {
		                return;
		            }
		        	
		        	List<CanAlarmVo> alarmList = alarmState.getAlarmList();
		        	
		        	Date now = new Date();
		        	
		        	for(CanAlarmVo vo : alarmList)
		        	{
		        		if (null != vo && null != vo.getAlarmNo() && null != vo.getAlarmValue())
		                {
		                    //如果报警时间为空或者报警时间在服务器时间之后或报警时间在服务器时间10分钟则直接丢弃
		                    if (null == vo.getAlarmTime() || null == vo.getAlarmTime()
		                            || vo.getAlarmTime().before(DateUtil.getOffsetMinute(now, -10)))
		                    {
		                        continue;
		                    }
		                    if (vo.getAlarmValue() == 1)
		                    {
		                        //如果判断到已经存在此故障则直接丢弃（终端重复上报）
		                        if (null != state.getCanAlarm(vo.getAlarmNo().toString()))
		                        {
		                            continue;
		                        }
		                        //报警开始
		                        state.addCanAlarm(new CanAlarm(machineryId, vo.getAlarmNo().toString(), vo.getAlarmTime(), vo
		                                .getAlarmMark(), alarmState.getLongitude(), alarmState.getLatitude()));
		                        machCacheService.updateMachAlarm(state);
		                        //报警开始
		                        this.addLog(state, vo.getAlarmMark().shortValue(), vo.getAlarmNo().toString(),
		                                vo.getAlarmTime(), alarmState.getLongitude(), alarmState.getLatitude(), true);
		                    }
		                    else if (vo.getAlarmValue() == 0)
		                    {
		                        //报警结束
		                        machCacheService.deleteMachAlarm(machineryId, vo.getAlarmNo().toString(), vo.getAlarmMark());
		                        //报警解除
		                        this.addLog(state, vo.getAlarmMark().shortValue(), vo.getAlarmNo().toString(),
		                                vo.getAlarmTime(), alarmState.getLongitude(), alarmState.getLatitude(), false);
		                    }
		                }
		        	}
		        }
		        
			}catch(Exception e)
			{
				LogUtil.getLogger(this).warn("获取kafka消息异常!",e);
			}
		}
	}
	
	
	/**
     * 处理报警记录
     * @param state
     * @param alarmNo
     * @param infoSource 0:系统故障  1:阈值故障
     * @param alarmTime
     * @param longitude
     * @param latitude
     * @param isBegin
     */
    private void addLog(MachCache state , Short infoSource , String alarmNo , Date alarmTime , Double longitude ,
            Double latitude , boolean isBegin)
    {
        if (isBegin)
        {
            //报警开始
            if (infoSource == 0)
            {
                FaultDefinition def = faultDefinitionCacheService.queryFaultDefinition(alarmNo, state.getAnalyzeType());
                if (null == def || null == def.getFaultCode())
                {
                    def = new FaultDefinition(alarmNo);
//                	return;
                }
                FaultMachinery faultLog = new FaultMachinery(state.getId(), alarmNo, alarmTime, longitude, latitude,
                        true);
                faultLog.setFaultDefinition(def);
                //保存报警记录
                globalQueue.addCurrentFault(faultLog);
            }
            else if (infoSource == 1)
            {
                AlarmDefinition def = alarmDefinitionCacheService.queryById(Integer.parseInt(alarmNo));
                if (null == def || null == def.getId())
                {
                    def = new AlarmDefinition(Integer.parseInt(alarmNo));
//                	return;
                }
                AlarmMachinery alarmLog = new AlarmMachinery(state.getId(), Integer.parseInt(alarmNo), alarmTime,
                        longitude, latitude, true);
                alarmLog.setAlarmDefinition(def);
                //保存报警记录
                globalQueue.addCurrentAlarm(alarmLog);
            }
        }
        else
        {
            //报警结束
            if (infoSource == 0)
            {
                FaultDefinition def = faultDefinitionCacheService.queryFaultDefinition(alarmNo.toString(),
                        state.getAnalyzeType());
                if (null == def || null == def.getFaultCode())
                {
                    def = new FaultDefinition(alarmNo.toString());
//                	return;
                }
                FaultMachinery faultLog = new FaultMachinery(state.getId(), alarmNo.toString(), alarmTime, longitude,
                        latitude, false);
                faultLog.setFaultDefinition(def);
                //保存报警记录
                globalQueue.addLogFault(faultLog);
            }
            else if (infoSource == 1)
            {
                AlarmDefinition def = alarmDefinitionCacheService.queryById(Integer.parseInt(alarmNo));
                if (null == def || null == def.getId())
                {
                    def = new AlarmDefinition(Integer.parseInt(alarmNo));
//                	return;
                }
                AlarmMachinery alarmLog = new AlarmMachinery(state.getId(), Integer.parseInt(alarmNo), alarmTime,
                        longitude, latitude, false);
                alarmLog.setAlarmDefinition(def);
                //保存报警记录
                globalQueue.addLogAlarm(alarmLog);
            }
        }

    }
}
