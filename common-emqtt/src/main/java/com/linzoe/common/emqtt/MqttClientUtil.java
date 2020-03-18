package com.linzoe.common.emqtt;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MqttClientUtil {

	@Value("${emqtt.url}")
	private String url;

	@Value("${emqtt.clientId:}")
	private String clientId;

	@Value("${emqtt.userName:}")
	private String userName;

	@Value("${emqtt.password:}")
	private String password;

	private MqttClient mqttClient;

	@PostConstruct
	public void init() {
		// 初始化 mqttClient
		try {
			mqttClient = new MqttClient(url, (StringUtils.isEmpty(clientId)) ? "clientId_" + new Random().nextInt(1000000000) : clientId, new MemoryPersistence());
			MqttConnectOptions options = new MqttConnectOptions();
			options.setCleanSession(true);
			if (!StringUtils.isEmpty(userName)) {
				options.setUserName(userName);
			}
			if (!StringUtils.isEmpty(password)) {
				options.setPassword(password.toCharArray());
			}
			// 设置超时时间
			options.setConnectionTimeout(6);
			// 设置会话心跳时间
			options.setKeepAliveInterval(10);
			options.setAutomaticReconnect(true);
			mqttClient.setCallback(new ReconnectSupportCallback());
			mqttClient.connect(options);
		} catch (MqttException e) {
			log.error("MQTT客户端初始化失败");
			log.error(e.getMessage(), e);
			System.exit(-1);
		}
	}

	public MqttClient getMqttClient() {
		return mqttClient;
	}
}
