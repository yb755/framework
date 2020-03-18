package com.linzoe.common.emqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmqttProducer {

	@Autowired
	private MqttClientUtil mqttClientUtil;

	public void sendMessage(String topic, byte[] message) {
		sendMessage(topic, 1, message);
	}

	public void sendMessage(String topic, String message) {
		sendMessage(topic, 1, message);
	}

	public void sendMessage(String topic, int qos, byte[] message) {
		MqttClient mqttClient = mqttClientUtil.getMqttClient();
		if (!mqttClient.isConnected()) {
			log.warn("客户端未连接");
			return;
		}
		MqttTopic mqttTopic = mqttClient.getTopic(topic);
		MqttMessage mqttMessage = new MqttMessage();
		mqttMessage.setPayload(message);
		mqttMessage.setQos(qos);
		try {
			MqttDeliveryToken deliveryToken = mqttTopic.publish(mqttMessage);
			if (deliveryToken != null) {
				log.debug("deliveryToken.response={}", deliveryToken);
			}
		} catch (MqttException e) {
			log.error(e.getMessage(), e);
		}
	}

	public void sendMessage(String topic, int qos, String message) {
		sendMessage(topic, qos, message.getBytes());
	}
}
