package com.linzoe.common.kafka.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultKafkaMessageHandler implements KafkaMessageHandler<Object> {

	private final Logger logger = LoggerFactory.getLogger(DefaultKafkaMessageHandler.class);

	@Override
	public void handler(String topic,Object message) {
		logger.info("默认处理器:收到消息={}", message);
	}

}
