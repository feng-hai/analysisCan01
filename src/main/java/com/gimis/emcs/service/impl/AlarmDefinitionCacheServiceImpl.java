
package com.gimis.emcs.service.impl;

import com.gimis.emcs.cachedao.AlarmDefinitionCacheDao;
import com.gimis.emcs.cachedao.impl.AlarmDefinitionCacheDaoImpl;
import com.gimis.emcs.domain.AlarmDefinition;
import com.gimis.emcs.service.AlarmDefinitionCacheService;

public class AlarmDefinitionCacheServiceImpl implements AlarmDefinitionCacheService
{

    private AlarmDefinitionCacheDao alarmDefinitionCacheDao;

    public AlarmDefinitionCacheServiceImpl()
    {
        alarmDefinitionCacheDao = new AlarmDefinitionCacheDaoImpl();
    }

    public AlarmDefinition queryById(Integer pk)
    {
        return alarmDefinitionCacheDao.queryById(pk);
    }

}
