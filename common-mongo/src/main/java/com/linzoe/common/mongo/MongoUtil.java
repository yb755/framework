package com.linzoe.common.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoUtil {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public MongoUtil(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public <T> void insert(T object) {
		mongoTemplate.insert(object);
	}

	public <T> void insert(T object, String collectionName) {
		mongoTemplate.insert(object, collectionName);
	}

	public <T> void insertBatch(List<T> list, String collectionName) {
		mongoTemplate.insert(list, collectionName);
	}

	public <T> T findOne(Query query, Class<T> entityClass, String collectionName) {
		return mongoTemplate.findOne(query, entityClass, collectionName);
	}

	public <T> List<T> findList(Query query, Class<T> entityClass, String collectionName) {
		return mongoTemplate.find(query, entityClass, collectionName);
	}

}
