package com.gimis.emcs.domain;

import java.util.Map;

public interface RedisModel<PK> {
	/**
     * 获取主键ID
     * @return
     */
    public PK getId();

    /**
     * 获取需要缓存的map属性
     * @return
     */
    public Map<String, String> getUpdateMap();
}
