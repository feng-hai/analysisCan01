package com.wlwltech.csrzic.redis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;


import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class RedisPool
{
	private static  JedisCluster jedisCluster=null;

	private static final RedisPool instance = new RedisPool();


	public static RedisPool getInstance()
	{
	
		return instance;
	}


	public RedisPool()
	{


		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		HashMap<String, String> prop = PropertyResource.getInstance().getProperties();
		config.setMaxTotal( Integer.parseInt( prop.get( "redis.max" ) ) );
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		String url = prop.get( "redis.server" );
		String[] jsis = url.split( "," );
		for ( String jsi : jsis )
		{
			String temp[] = jsi.split( ":" );
			nodes.add( new HostAndPort( temp[0], Integer.parseInt( temp[1] ) ) );
			System.out.println( "redis" + temp[0] + ":" + temp[1] );
		}
		jedisCluster = new JedisCluster( nodes, config );
	}


	public JedisCluster getJedisCluster()
	{
		if(jedisCluster==null)
		{

			GenericObjectPoolConfig config = new GenericObjectPoolConfig();
			HashMap<String, String> prop = PropertyResource.getInstance().getProperties();
			config.setMaxTotal( Integer.parseInt( prop.get( "redis.max" ) ) );
			Set<HostAndPort> nodes = new HashSet<HostAndPort>();
			String url = prop.get( "redis.server" );
			String[] jsis = url.split( "," );
			for ( String jsi : jsis )
			{
				String temp[] = jsi.split( ":" );
				nodes.add( new HostAndPort( temp[0], Integer.parseInt( temp[1] ) ) );
				System.out.println( "redis" + temp[0] + ":" + temp[1] );
			}
			jedisCluster = new JedisCluster( nodes, config );
		}
		return jedisCluster;
	}





	

}
