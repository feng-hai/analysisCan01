package com.wlwltech.pages;

import java.net.InetAddress;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EsutilSingle {

	@SuppressWarnings("resource")
	private EsutilSingle() {
		if (client == null) {
			// logger.error("ES开始连接02");
			Settings settings = Settings.builder().put("cluster.name", "Heracles")// 集群名称
					.put("client.transport.sniff", true)// 自动嗅探整个ES集群节点
					.put("transport.type", "netty3").put("http.type", "netty3").build();//// 每5秒提交一次数据，类似oracle中的commit

			try {
				// client = new PreBuiltTransportClient(settings);
				// String servers =
				// PropertyResource.getInstance().getProperties().get("index.server");
				// String[] serverIndex = servers.split(",");
				// for (String index : serverIndex) {
				//
				// client.addTransportAddress(new
				// InetSocketTransportAddress(InetAddress.getByName(index),
				// 9300));
				// }
				logger.error("ES开始连接！");
				client = new PreBuiltTransportClient(settings)
						.addTransportAddress(
								new InetSocketTransportAddress(InetAddress.getByName("192.168.21.9"), 9300))
						.addTransportAddress(
								new InetSocketTransportAddress(InetAddress.getByName("192.168.21.10"), 9300))
						.addTransportAddress(
								new InetSocketTransportAddress(InetAddress.getByName("192.168.21.11"), 9300))
						.addTransportAddress(
								new InetSocketTransportAddress(InetAddress.getByName("192.168.21.12"), 9300))
						.addTransportAddress(
								new InetSocketTransportAddress(InetAddress.getByName("192.168.21.13"), 9300));
				logger.error("ES连接系统成功创建客户端！");
			} catch (Exception e) {
				// e.printStackTrac();
				logger.error("连接索引错误", e);
			}

		}
	}

	private static final Logger logger = LoggerFactory.getLogger(EsutilSingle.class);
	private static TransportClient client = null;

	@SuppressWarnings("resource")
	public static TransportClient getClient() {
		// logger.error("ES开始连接01");
		if (client == null) {
			// logger.error("ES开始连接02");
			Settings settings = Settings.builder().put("cluster.name", "Heracles")// 集群名称
					.put("client.transport.sniff", true)// 自动嗅探整个ES集群节点
					.put("transport.type", "netty3").put("http.type", "netty3").build();//// 每5秒提交一次数据，类似oracle中的commit

			try {
				// client = new PreBuiltTransportClient(settings);
				// String servers =
				// PropertyResource.getInstance().getProperties().get("index.server");
				// String[] serverIndex = servers.split(",");
				// for (String index : serverIndex) {
				//
				// client.addTransportAddress(new
				// InetSocketTransportAddress(InetAddress.getByName(index),
				// 9300));
				// }
				logger.error("ES开始连接！");
				client = new PreBuiltTransportClient(settings)
						.addTransportAddress(
								new InetSocketTransportAddress(InetAddress.getByName("192.168.21.9"), 9300))
						.addTransportAddress(
								new InetSocketTransportAddress(InetAddress.getByName("192.168.21.10"), 9300))
						.addTransportAddress(
								new InetSocketTransportAddress(InetAddress.getByName("192.168.21.11"), 9300))
						.addTransportAddress(
								new InetSocketTransportAddress(InetAddress.getByName("192.168.21.12"), 9300))
						.addTransportAddress(
								new InetSocketTransportAddress(InetAddress.getByName("192.168.21.13"), 9300));
				logger.error("ES连接系统成功创建客户端！");
			} catch (Exception e) {
				// e.printStackTrac();
				logger.error("连接索引错误", e);
			}

		}
		return client;
	}

}
