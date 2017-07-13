package com.gimis.emcs.cachedao;

import java.util.Map;
import java.util.Set;

import com.gimis.emcs.domain.vo.CanAlarm;

public interface AlarmCacheDao {
	
	/**
     * 查询车辆故障信息 key:alarmNo
     * @param machineryId  终端id
     * @param alarmMark  报警标记 0:系统故障码  1:阈值故障码
     * @return 定义信息
     */
    public Map<String, CanAlarm> queryAlarmMap(Integer machineryId , Integer alarmMark);

    /**
     * 查询故障码
     * @param machineryId 终端id
     * @param alarmMark  报警标记 0:系统故障码  1:阈值故障码
     * @return  故障set
     */
    public Set<String> queryAlarmNo(Integer machineryId , Integer alarmMark);
    
    /**
     * 新增报警记录
     * @param machineryId 终端id
     * @param alarmMap  报警map
     */
    public void addAlarm(Integer machineryId , Map<String, CanAlarm> alarmMap);
    
    /**
     * 新增报警记录
     * @param machineryId 终端id
     * @param alarm      报警类
     * @param alarmMark  报警标记 0:系统故障码  1:阈值故障码
     */
    public void addAlarm(Integer machineryId , CanAlarm alarm , Integer alarmMark);
    
    /**
     * 删除报警记录
     * @param machineryId 终端id
     * @param alarmNo     报警
     * @param alarmMark  报警标记 0:系统故障码  1:阈值故障码
     */
    public void deleteAlarm(Integer machineryId , String alarmNo , Integer alarmMark);
}
