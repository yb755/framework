package com.linzoe.common.mqtt;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.linzoe.boot.Application;
import com.linzoe.common.emqtt.EmqttConsumer;
import com.linzoe.common.emqtt.EmqttProducer;
import com.linzoe.common.emqtt.MqttMessageHandler;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MqttConsumer {

	@Autowired
	private EmqttConsumer emqttConsumer;

	@Autowired
	private EmqttProducer emqttProducer;

	// @Test
	public void testMqttConsumer() {
		emqttConsumer.subcribTopic(new String[] { "$D/+" }, new int[] { 0 }, new MyMessageHandler());
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testMqttProducer() throws InterruptedException {
		while (true) {
			emqttProducer.sendMessage("abc", "ddddd");
			Thread.sleep(1000);
		}
	}

	static class MyMessageHandler implements MqttMessageHandler {

		@Override
		public void handler(String topic, MqttMessage mqttMessage) {
			System.out.println(topic);
		}

	}
}
