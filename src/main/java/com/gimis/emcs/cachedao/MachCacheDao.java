package com.gimis.emcs.cachedao;

import java.util.Map;

import com.gimis.emcs.domain.vo.MachCache;

public interface MachCacheDao {

	/**
     * 查询设备内存
     * @param machineryId
     * @return 定义信息
     */
    public MachCache queryMach(Integer machineryId);
    
    /**
     * 更新设备内存
     * @param mach
     */
    public void updateMach(MachCache mach);
    
    /**
     * 更新设备多个属性
     * @param machineryId
     * @param param
     */
    public void updateMach(Integer machineryId , Map<String, String> param);
}
