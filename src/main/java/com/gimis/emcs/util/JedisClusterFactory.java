
package com.gimis.emcs.util;

import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * Redis 工厂类
* [一句话功能简述]<p>
* [功能详细描述]<p>
* @author yanshuai
* @version 1.0, 2016年11月28日

* @since V1.0
 */
public class JedisClusterFactory
{
    private static final JedisClusterFactory instance = new JedisClusterFactory();

    private JedisCluster jedisCluster;

    private Properties props;
    /**
     * 单例实现
     * @return JedisClusterFactory
     */
    public static JedisClusterFactory getInstance()
    {
        return instance;
    }

    private JedisClusterFactory()
    {
        props = new Properties();
        
        try
        {
            props.load(JedisClusterFactory.class.getClassLoader().getResourceAsStream("redis.properties"));
            
            Set<HostAndPort> nodes = new HashSet<HostAndPort>();

            String[] hps = props.getProperty("redis.server").split(",");

            for (String hp : hps)
            {
                String[] tmp = hp.split(":");
                nodes.add(new HostAndPort(tmp[0], Integer.parseInt(tmp[1])));
            }
            //设置属性
            GenericObjectPoolConfig config = new GenericObjectPoolConfig();
            config.setMaxTotal(Integer.valueOf(props.getProperty("redis.maxTotal")));
            config.setMaxIdle(Integer.valueOf(props.getProperty("redis.maxIdle")));
            config.setMaxWaitMillis(Integer.valueOf(props.getProperty("redis.maxWaitMills")));
            config.setTestOnBorrow(Boolean.valueOf(props.getProperty("redis.testOnBorrow")));

            jedisCluster = new JedisCluster(nodes, config);
            
        }
        catch (IOException e)
        {
            LogUtil.getLogger(this).error("配置Redis工厂异常",e);
        }
        

    }

    public boolean isShareMode() {
        if(null != props.getProperty("redis.shareMode"))
        {
            return Boolean.valueOf(props.getProperty("redis.shareMode"));
        }
        return false;
    }
    
    public JedisCluster getResource()
    {
        return jedisCluster;
    }
}
