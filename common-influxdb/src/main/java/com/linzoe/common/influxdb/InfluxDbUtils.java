package com.linzoe.common.influxdb;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Query;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class InfluxDbUtils {

	private String userName;
	private String password;
	private String url;
	public String database;
	private String retentionPolicy;
	// InfluxDB实例
	private InfluxDB influxDB;

	// 数据保存策略
	public static String policyNamePix = "logRetentionPolicy_";

	public InfluxDbUtils(String userName, String password, String url, String database, String retentionPolicy) {
		this.userName = userName;
		this.password = password;
		this.url = url;
		this.database = database;
		this.retentionPolicy = retentionPolicy == null || "".equals(retentionPolicy) ? "autogen" : retentionPolicy;
		this.influxDB = influxDbBuild();
	}

	/**
	 * 连接数据库 ，若不存在则创建
	 *
	 * @return influxDb实例
	 */
	private InfluxDB influxDbBuild() {
		if (influxDB == null) {
			influxDB = InfluxDBFactory.connect(url, userName, password);
		}
		try {
			influxDB.query(new Query("CREATE DATABASE " + database));
			influxDB.setDatabase(database);
		} catch (Exception e) {
			log.error("create influx db failed, error: {}", e.getMessage());
		} finally {
			influxDB.query(new Query("CREATE RETENTION POLICY " + retentionPolicy + " ON " + database + " DURATION 30h REPLICATION 2 SHARD DURATION 30m DEFAULT"));
			influxDB.setRetentionPolicy(retentionPolicy);
		}
		influxDB.setLogLevel(InfluxDB.LogLevel.BASIC);
		return influxDB;
	}
}
