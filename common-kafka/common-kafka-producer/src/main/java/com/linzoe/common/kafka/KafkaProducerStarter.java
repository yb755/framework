package com.linzoe.common.kafka;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.linzoe.common.kafka.producer.KafkaMessageProducer;

@Component
public class KafkaProducerStarter {

	@Value("${kafka.bootstrap-servers}")
	private String brokerList;

	@Value("${kafka.producer.retries:3}")
	private int retries;

	@Value("${kafka.producer.acks:-1}")
	private String acks;

	@Value("${kafka.producer.batch-size:16384}")
	private int batchSize;

	@Value("${kafka.producer.buffer-memory:33554432}")
	private int bufferMemory;
	
	@Value("${kafka.producer.key-serializer:org.apache.kafka.common.serialization.StringSerializer}")
	private String keySerializer;
	
	@Value("${kafka.producer.value-serializer:org.apache.kafka.common.serialization.StringSerializer}")
	private String valueSerializer;

	@Autowired
	private KafkaMessageProducer kafkaMessageProducer;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostConstruct
	public void initProducer() {
		Properties props = new Properties();
		props.put("bootstrap.servers", brokerList);
		props.put("acks", acks);
		props.put("retries", retries);
		props.put("batch.size", batchSize);
		props.put("linger.ms", 10);
		props.put("buffer.memory", bufferMemory);
		props.put("max.block.ms", 3000);
		StringSerializer keySerializer = new StringSerializer();
		StringSerializer valueSerializer = new StringSerializer();
		Producer<String, String> producer = new KafkaProducer<String, String>(props, keySerializer, valueSerializer);
		kafkaMessageProducer.setProducer((KafkaProducer) producer);
	}
}
