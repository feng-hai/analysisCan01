package com.gimis.emcs.service;

import java.util.List;

import com.gimis.emcs.domain.FaultMachinery;

public interface FaultMachineryLogService {

	/**
     * 新增报警记录
     * @param list
     */
    public void add(List<FaultMachinery> list);

    public void add(FaultMachinery fm);
    
    /**
     * 更新报警结束信息
     * @param list
     */
    public void updateAlarmEnd(List<FaultMachinery> list);
    
    /**
     * 分页查询
     * @return
     */
    public List<FaultMachinery> queryList();
}
