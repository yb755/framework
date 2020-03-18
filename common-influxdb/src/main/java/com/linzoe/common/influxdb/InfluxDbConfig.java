package com.linzoe.common.influxdb;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@Configurable
public class InfluxDbConfig {

	@Value("${spring.influx.url:''}")
	private String influxDBUrl;

	@Value("${spring.influx.user:''}")
	private String userName;

	@Value("${spring.influx.password:''}")
	private String password;

	@Value("${spring.influx.database:''}")
	private String database;

	@Bean
	public InfluxDbUtils influxDbUtils() {
		return new InfluxDbUtils(userName, password, influxDBUrl, database, "");
	}
}
