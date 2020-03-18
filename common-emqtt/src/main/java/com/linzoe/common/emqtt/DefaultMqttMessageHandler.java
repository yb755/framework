package com.linzoe.common.emqtt;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

import com.linzoe.common.utils.ByteUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DefaultMqttMessageHandler implements MqttMessageHandler {

	@Override
	public void handler(String topic, MqttMessage mqttMessage) {
		log.info("收到mqtt消息,topic={},content={}", topic, ByteUtil.bytesToHexString(mqttMessage.getPayload()));
	}

}
