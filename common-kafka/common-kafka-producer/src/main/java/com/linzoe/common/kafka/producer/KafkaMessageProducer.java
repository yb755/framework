package com.linzoe.common.kafka.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageProducer {

	private final Logger logger = LoggerFactory.getLogger(KafkaMessageProducer.class);

	private KafkaProducer<String, String> producer;

	@Value("${kafka.topic.partition.count:1}")
	private int topicPartitionCount;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void sendMessage(String topic, String partitionKey, String message) {
		int hashCode = partitionKey.hashCode();
		int partition = Math.abs(hashCode) % topicPartitionCount;
		producer.send(new ProducerRecord(topic, partition, null, message), new Callback() {

			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {
				logger.debug(metadata.partition() + "," + metadata.offset());
			}

		});
	}

	public void setProducer(KafkaProducer<String, String> producer) {
		this.producer = producer;
	}

}
