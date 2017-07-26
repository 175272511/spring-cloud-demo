package com.zibba;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * 服务消费者
 */
//服务注册与发现
@EnableDiscoveryClient
@SpringBootApplication
//feign声明式服务
@EnableFeignClients
public class EurekaConsumerApplication {

	/**
	 * 定义输出日志级别
	 * @return
	 */
	@Bean
	Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerApplication.class, args);
	}
}
