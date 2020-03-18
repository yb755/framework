package com.linzoe.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = { "classpath*:config/biz-*.xml" })
@ComponentScan(basePackages = { "com.linzoe" })
@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static final String SHUTDOWN_HOOK_KEY = "shutdown.hook";
	private static volatile boolean running = true;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		if ("true".equals(System.getProperty(SHUTDOWN_HOOK_KEY))) {
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					// 退出系统
					System.out.println("正在退 出系统...");
					logger.info("正在退 出系统...");
					synchronized (Application.class) {
						running = false;
						Application.class.notify();
					}
				}
			});
		}
		synchronized (Application.class) {
			while (running) {
				try {
					Application.class.wait();
				} catch (Throwable e) {
				}
			}
		}
	}
}
