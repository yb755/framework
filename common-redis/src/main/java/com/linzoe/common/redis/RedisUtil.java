package com.linzoe.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

	private final StringRedisTemplate redisTemplate;

	@Autowired
	public RedisUtil(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public StringRedisTemplate getRedisTemplate() {
		return redisTemplate;
	}

	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	public String getByHashKey(String key, String hashKey) {
		HashOperations<String, String, String> opertions = redisTemplate.opsForHash();
		return opertions.get(key, hashKey);
	}

	public void putByHashKey(String key, String hashKey, String value) {
		HashOperations<String, String, String> opertions = redisTemplate.opsForHash();
		opertions.put(key, hashKey, value);
	}

	/**
	 * 保存验证码 时间秒数
	 */
	public void saveVeriCode( String key, String value,long time ) {
		redisTemplate.opsForValue().set( key, value , time, TimeUnit.SECONDS );
	}

	/**
	 * 获取验证码
	 * @param phone
	 * @return
	 */
	public String getVeriCode( String phone ) {
		return redisTemplate.opsForValue().get(phone);
	}
}
