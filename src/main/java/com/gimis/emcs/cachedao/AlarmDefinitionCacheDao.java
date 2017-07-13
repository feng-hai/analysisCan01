package com.gimis.emcs.cachedao;

import com.gimis.emcs.domain.AlarmDefinition;

public interface AlarmDefinitionCacheDao {

    /**
     * 查询自定义故障
     * @param pk  信息
     * @return  定义信息
     */
    public AlarmDefinition queryById(Integer pk);
}
