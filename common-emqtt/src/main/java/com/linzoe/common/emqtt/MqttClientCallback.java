package com.linzoe.common.emqtt;

import java.util.Arrays;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("mqttClientCallback")
public class MqttClientCallback implements MqttCallbackExtended {

	private MqttMessageHandler mqttMessageHandler;

	private MqttClient mqttClient;

	private String[] topics;

	private int[] qos;

	public void setMqttClient(MqttClient mqttClient) {
		this.mqttClient = mqttClient;
	}

	public void setTopics(String[] topics) {
		this.topics = topics;
	}

	public void setQos(int[] qos) {
		this.qos = qos;
	}

	public void setMqttMessageHandler(MqttMessageHandler mqttMessageHandler) {
		this.mqttMessageHandler = mqttMessageHandler;
	}

	@Override
	public void connectionLost(Throwable cause) {
		log.warn("mqtt连接丢失");
		log.warn(cause.getMessage(), cause);

	}

	@Override
	public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
		try {
			mqttMessageHandler.handler(topic, mqttMessage);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
	}

	@Override
	public void connectComplete(boolean reconnect, String serverURI) {
		if (reconnect) {
			log.info("服务器重连成功");
			try {
				mqttClient.subscribe(topics, qos);
				log.info("订阅主题成功={}", Arrays.asList(topics));
			} catch (MqttException e) {
				log.error(e.getMessage(), e);
			}
		} else {
			log.info("初始连接服务器成功");
		}
	}

}
