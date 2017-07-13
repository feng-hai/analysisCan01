package com.gimis.emcs.service;

import com.gimis.emcs.domain.FaultDefinition;

public interface FaultDefinitionCacheService {

	/**
     * 根据故障码查询故障码定义
     * @param faultCode
     * @return
     */
    public FaultDefinition queryFaultDefinition(String faultCode , Integer analyzeType);
}
