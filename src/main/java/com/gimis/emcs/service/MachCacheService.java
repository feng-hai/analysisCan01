package com.gimis.emcs.service;

import com.gimis.emcs.domain.vo.MachCache;


public interface MachCacheService {

	  /**
     * 查询车辆信息和车辆故障
     * @param machineryId
     * @return
     */
    public MachCache queryMachAlarm(Integer machineryId);
    
    /**
     * 更新设备内存+报警内存
     * @param machCache
     */
    public void updateMachAlarm(MachCache machCache);
    
    
    /**
     * 删除报警
     * @param machineryId
     * @param alarmNo
     * @param alarmMark
     */
    public void deleteMachAlarm(Integer machineryId , String alarmNo , Byte alarmMark);
	
}
