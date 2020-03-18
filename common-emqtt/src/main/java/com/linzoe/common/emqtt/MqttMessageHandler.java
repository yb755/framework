package com.linzoe.common.emqtt;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public interface MqttMessageHandler {

	void handler(String topic,MqttMessage mqttMessage);
}
