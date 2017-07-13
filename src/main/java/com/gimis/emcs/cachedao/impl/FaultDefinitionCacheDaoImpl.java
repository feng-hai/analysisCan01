package com.gimis.emcs.cachedao.impl;

import java.util.Map;

import com.gimis.emcs.cachedao.FaultDefinitionCacheDao;
import com.gimis.emcs.domain.FaultDefinition;

public class FaultDefinitionCacheDaoImpl extends AbstractCommonCacheDao
		implements FaultDefinitionCacheDao {

	private static final String NAMESPACE_FAULT_CODE = "faultCode";

	public FaultDefinition queryFaultDefinition(String faultCode,
			Integer analyzeType) {
		// TODO Auto-generated method stub
		if (null == faultCode) {
			return null;
		}
		String key = this.getNameSpace(NAMESPACE_FAULT_CODE) + KEY_SPLIT
				+ faultCode;
		if (null != analyzeType && analyzeType > 0) {

			key = key + KEY_SEPREATE + analyzeType;
		}
		Map<String, String> result = jedisClusterFactory.getResource().hgetAll(key);
		
		if (null != result && result.size() <= 0) {
			return null;
		}
		
		return new FaultDefinition(result);
	}

}
