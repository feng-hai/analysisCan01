package com.gimis.emcs.cachedao.impl;

import com.gimis.emcs.util.JedisClusterFactory;


public class AbstractCommonCacheDao {
	
	public static final String KEY_SPLIT = ":";

	public static final String KEY_SYSTEM = "#";
	
	public static final String KEY_SEPREATE = "-";
	
	protected static final JedisClusterFactory jedisClusterFactory = JedisClusterFactory.getInstance();
	
	protected String getNameSpace(String namespace)
	{
		if(jedisClusterFactory.isShareMode())
		{
			namespace = namespace + KEY_SYSTEM + 1002;
		}
		return namespace;
	}
}
