package com.linzoe.common.kafka.handler;

import java.util.HashMap;
import java.util.Map;

public interface KafkaMessageHandler<T> {

	Map<String, KafkaMessageHandler<String>> HANDLER_MAP = new HashMap<String, KafkaMessageHandler<String>>();

	void handler(String topic, T message);
}
