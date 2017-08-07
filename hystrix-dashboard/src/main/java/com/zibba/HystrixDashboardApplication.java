package com.zibba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 监控平台,监控请求数,熔断数等
 * 需要开启turbine-amqp实现集群监控数据采集
 * 访问 http://localhost:1000/hystrix.stream
 * 输入turbine监控 http://localhost:1001/turbine.stream
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}
}
