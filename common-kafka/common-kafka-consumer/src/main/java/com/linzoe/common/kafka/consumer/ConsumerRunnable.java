package com.linzoe.common.kafka.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.linzoe.common.kafka.handler.KafkaMessageHandler;

/**
 * 1、KafkaConsumer是非线程安全的，KafkaProducer是线程安全的。<br>
 * 2、该案例是每个线程维护一个KafkaConsumer实例,
 * 用户创建多个线程消费topic数据，每个线程都会创建专属该线程的KafkaConsumer实例<br>
 * 3、ConsumerRunnable，消费线程类，执行真正的消费任务<br>
 * 
 * @author Administrator
 *
 */
public class ConsumerRunnable implements Runnable {

	private final Logger logger = LoggerFactory.getLogger(ConsumerRunnable.class);

	// 每个线程维护私有的kafkaConsumer实例
	private final KafkaConsumer<String, String> consumer;

	private KafkaMessageHandler<String> kafkaMessageHandler;

	public ConsumerRunnable(String brokerList, String groupId, String topic, String offset, String keyDeserializer, String valueDeserializer, KafkaMessageHandler<String> kafkaMessageHandler) {
		// 带参数的构造方法
		Properties props = new Properties();
		// kafka的列表
		props.put("bootstrap.servers", brokerList);
		// 消费者组编号
		props.put("group.id", groupId);
		// 自动提交
		props.put("enable.auto.commit", true);
		// 提交每个一秒钟
		props.put("auto.commit.interval.ms", "1000");
		// offset设置
		props.put("auto.offset.reset", offset);
		// 反序列化key
		props.put("key.deserializer", keyDeserializer);
		// 反序列化value
		props.put("value.deserializer", valueDeserializer);
		// 将配置信息进行初始化操作
		this.consumer = new KafkaConsumer<>(props);
		this.kafkaMessageHandler = kafkaMessageHandler;
		// 定义响应的主题信息topic
		consumer.subscribe(Arrays.asList(topic.split(",")));
	}

	@Override
	public void run() {
		if (kafkaMessageHandler == null) {
			logger.error("未正确配置kafka消息处理器");
			System.exit(0);
			return;
		}
		// 消费者保持一直消费的状态
		while (true) {
			// 将获取到消费的信息
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(200));
			// 遍历出每个消费的消息
			for (ConsumerRecord<String, String> record : records) {
				if (logger.isDebugEnabled()) {
					logger.debug("record={}", record);
				}
				kafkaMessageHandler.handler(record.topic(), record.value());
			}
		}
	}

}
