package com.gimis.emcs.service;

import java.util.List;

import com.gimis.emcs.domain.AlarmMachinery;

public interface AlarmMachineryLogService {

	/**
     * 新增报警记录
     * @param list
     */
    public void add(List<AlarmMachinery> list);

    public void add(AlarmMachinery am);
    
    /**
     * 更新报警结束信息
     * @param list
     */
    public void updateAlarmEnd(List<AlarmMachinery> list);
}
