package com.zibba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 配置中心客户端
 * 集成了分布式配置、turbine-hystrix监控管理、sleuth-zipkin服务跟踪
 * 引入<dependency>
 * <groupId>com.zibba</groupId>
 * <artifactId>config-client</artifactId>
 * <version>0.0.1-SNAPSHOT</version>
 * </dependency>
 *
 * 配置文件加上
 * spring.application.name=@pom.name@
 * #读取多个配置文件,先读common,再读私有配置,以私有配置为主要配置
 * spring.cloud.config.name=common,${spring.application.name}
 *
 * 注解加上
 * //开启断路器 新版默认开启了,不需要加
 * @EnableCircuitBreaker
 */
//@EnableDiscoveryClient
//@SpringBootApplication
//public class ConfigClientApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(ConfigClientApplication.class, args);
//	}
//}
