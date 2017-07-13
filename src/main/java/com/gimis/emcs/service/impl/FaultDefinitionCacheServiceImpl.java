
package com.gimis.emcs.service.impl;

import com.gimis.emcs.cachedao.FaultDefinitionCacheDao;
import com.gimis.emcs.cachedao.impl.FaultDefinitionCacheDaoImpl;
import com.gimis.emcs.domain.FaultDefinition;
import com.gimis.emcs.service.FaultDefinitionCacheService;

/**
 * 故障定义缓存Service
 * @author lion
 *
 */
public class FaultDefinitionCacheServiceImpl implements FaultDefinitionCacheService
{

    private FaultDefinitionCacheDao faultDefinitionCacheDao;

    public FaultDefinitionCacheServiceImpl()
    {
        faultDefinitionCacheDao = new FaultDefinitionCacheDaoImpl();
    }

    public FaultDefinition queryFaultDefinition(String faultCode , Integer analyzeType)
    {
        return faultDefinitionCacheDao.queryFaultDefinition(faultCode, analyzeType);
    }

}
