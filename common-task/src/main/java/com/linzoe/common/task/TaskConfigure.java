package com.linzoe.common.task;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;

@Configuration
public class TaskConfigure {

	@Value("${xxl.job.admin.addresses}")
	private String adminAddresses;

	@Value("${xxl.executor.name}")
	private String executorName;

	@Value("${xxl.executor.ip:}")
	private String ip;

	@Value("${xxl.executor.port:0}")
	private int port;

	@Value("${xxl.executor.logpath:}")
	private String logPath;

	@Value("${xxl.executor.logretentiondays:-1}")
	private int logRetentionDays;

	@Bean(initMethod = "start", destroyMethod = "destroy")
	public XxlJobSpringExecutor xxlJobSpringExecutor() {
		XxlJobSpringExecutor executor = new XxlJobSpringExecutor();
		executor.setAdminAddresses(adminAddresses);
		executor.setAppName(executorName);
		executor.setPort(port);
		executor.setLogRetentionDays(logRetentionDays);
		executor.setLogPath(logPath);
		executor.setIp(ip);
		return executor;
	}
}
