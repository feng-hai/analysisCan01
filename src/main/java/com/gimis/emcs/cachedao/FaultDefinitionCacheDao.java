package com.gimis.emcs.cachedao;

import com.gimis.emcs.domain.FaultDefinition;

public interface FaultDefinitionCacheDao {

	 /**
     * 根据故障码查询故障码定义
     * @param faultCode  故障码
     * @return   定义信息
     */
    /**
 
     * @param analyzeType 分析类型
    
     */
    public FaultDefinition queryFaultDefinition(String faultCode , Integer analyzeType);
}
