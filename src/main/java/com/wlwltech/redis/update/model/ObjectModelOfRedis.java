package com.wlwltech.redis.update.model;

import java.util.Map;

public class ObjectModelOfRedis {
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Map<String, String> getRedisValues() {
		return redisValues;
	}
	public void setRedisValues(Map<String, String> redisValues) {
		this.redisValues = redisValues;
	}
	private String key;
	private Map<String,String> redisValues;

}
