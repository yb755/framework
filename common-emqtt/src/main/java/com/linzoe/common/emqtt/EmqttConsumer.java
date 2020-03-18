package com.linzoe.common.emqtt;

import javax.annotation.Resource;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmqttConsumer {

	@Autowired
	private MqttClientUtil mqttClientUtil;

	@Resource(name = "mqttClientCallback")
	private MqttClientCallback mqttCallback;

	@Autowired
	private DefaultMqttMessageHandler defaultHandler;

	public void subcribTopic(String[] topics,int[] qos, MqttMessageHandler mqttMessageHandler) {
		try {
			MqttClient mqttClient = mqttClientUtil.getMqttClient();
			if (mqttMessageHandler != null) {
				mqttCallback.setMqttMessageHandler(mqttMessageHandler);
			} else {
				mqttCallback.setMqttMessageHandler(defaultHandler);
			}
			mqttCallback.setMqttClient(mqttClient);
			mqttCallback.setTopics(topics);
			mqttCallback.setQos(qos);
			mqttClient.setCallback(mqttCallback);
			mqttClient.subscribe(topics);
		} catch (MqttException e) {
			log.error(e.getMessage(), e);
		}
	}
}
