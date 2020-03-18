package com.linzoe.common.jackson;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ObjectMapperUtil {

	private static ObjectMapper objectMapper = new ObjectMapper();

	static {
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true); // 格式化输出
		objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true); // 键按自然顺序输出
		objectMapper.setSerializationInclusion(Include.NON_EMPTY); // 忽略POJO中属性为空的字段
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // 忽略未知的属性
		// 指定遇到date按照这种格式转换
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		objectMapper.setDateFormat(fmt);
	}

	public static ObjectMapper getObjectMapper() {
		return objectMapper;
	}
}
