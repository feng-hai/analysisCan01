package com.gimis.emcs.cachedao.impl;

import java.util.Map;

import com.gimis.emcs.cachedao.AlarmDefinitionCacheDao;
import com.gimis.emcs.domain.AlarmDefinition;

public class AlarmDefinitionCacheDaoImpl extends AbstractCommonCacheDao implements AlarmDefinitionCacheDao {

	private static final String NAMESPACE_ALARM_DEFINITION = "alarmDefinition";
	
	public AlarmDefinition queryById(Integer pk) {
		// TODO Auto-generated method stub
		if (null == pk)
        {
            return null;
        }
        String key = this.getNameSpace(NAMESPACE_ALARM_DEFINITION) + KEY_SPLIT + pk;
        Map<String, String> result = jedisClusterFactory.getResource().hgetAll(key);
        if (result == null)
        {
            return null;
        }
        return new AlarmDefinition(result);
	}

}
