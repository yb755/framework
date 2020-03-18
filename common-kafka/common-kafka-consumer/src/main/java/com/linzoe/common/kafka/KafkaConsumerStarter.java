package com.linzoe.common.kafka;

import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.linzoe.common.kafka.consumer.ConsumerGroup;
import com.linzoe.common.kafka.handler.KafkaMessageHandler;

@Component
public class KafkaConsumerStarter implements ApplicationContextAware {

	@Value("${kafka.bootstrap-servers}")
	private String brokerList;

	@Value("${kafka.consumer.group-id}")
	private String groupId;

	@Value("${kafka.consumer.topic}")
	private String topic;

	@Value("${kafka.consumer.size:3}")
	private int consumerNum;

	@Value("${kafka.consumer.auto-offset-reset:latest}")
	private String offset;

	@Value("${kafka.consumer.key-deserializer:org.apache.kafka.common.serialization.StringDeserializer}")
	private String keyDeserializer;

	@Value("${kafka.consumer.value-deserializer:org.apache.kafka.common.serialization.StringDeserializer}")
	private String valueDeserializer;

	@Value("${kafka.consumer.handler:com.linzoe.common.kafka.handler.DefaultKafkaMessageHandler}")
	private String handlerClassName;

	@PostConstruct
	public void initConsumer() {
		// 通过构造器创建出一个对象
		ConsumerGroup consumerGroup = new ConsumerGroup(consumerNum, groupId, topic, brokerList, offset, keyDeserializer, valueDeserializer, handlerClassName);
		// 执行execute的方法，创建出ConsumerRunnable消费者实例。多线程多消费者实例
		consumerGroup.execute();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		Map<String, KafkaMessageHandler> beansMap = applicationContext.getBeansOfType(KafkaMessageHandler.class);
		Set<String> keys = beansMap.keySet();
		for (String key : keys) {
			KafkaMessageHandler<String> handler = beansMap.get(key);
			KafkaMessageHandler.HANDLER_MAP.put(handler.getClass().getName(), handler);
		}
	}
}
