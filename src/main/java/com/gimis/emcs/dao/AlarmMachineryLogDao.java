package com.gimis.emcs.dao;

import java.util.List;

import com.gimis.emcs.domain.AlarmMachinery;

public interface AlarmMachineryLogDao {

	/**
     * 新增报警记录
     * @param list
     */
    public void add(List<AlarmMachinery> list);

    /**
     * 新增报警记录
     * @param am
     */
    public void add(AlarmMachinery am);
    
    /**
     * 更新报警结束信息
     * @param list
     */
    public void updateAlarmEnd(List<AlarmMachinery> list);
}
