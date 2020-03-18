package com.linzoe.common.redis.cluster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisClusterStringUtil {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public RedisTemplate<String, String> getRedisTemplate() {
		return redisTemplate;
	}

	public String get(String key) {
		if (key == null) {
			return null;
		}
		final String redisKey = key;
		String value = redisTemplate.execute(new RedisCallback<String>() {
			// 这里返回值是个上面的RedisCallback<Integer> 中的泛型一直，
			public String doInRedis(RedisConnection connection) {
				byte[] bytes = connection.get(redisKey.getBytes());
				return new String(bytes);
			}
		});
		return value;
	}

	public void set(String key, String value) {
		final String redisKey = key;
		final String redisValue = value;
		redisTemplate.execute(new RedisCallback<Void>() {

			@Override
			public Void doInRedis(RedisConnection connection) throws DataAccessException {
				connection.set(redisKey.getBytes(), redisValue.getBytes());
				return null;
			}

		});
	}
}
