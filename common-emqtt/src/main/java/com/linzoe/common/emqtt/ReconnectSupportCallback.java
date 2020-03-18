package com.linzoe.common.emqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReconnectSupportCallback implements MqttCallbackExtended {

	@Override
	public void connectComplete(boolean reconnect, String serverURI) {
		if (reconnect) {
			log.info("服务器重连成功 ");
		} else {
			log.info("服务器第一次连接成功 ");
		}
	}

	@Override
	public void connectionLost(Throwable cause) {
		log.warn("连接丢失");
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {

	}

}
