package com.zibba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * 打开http://localhost:9411访问监控中心,可用来查看慢链接等
 * 默认数据保存在内存,可配置保存mysql或elasticsearch,参考http://www.jianshu.com/p/3af076572ab3
 */
@EnableZipkinStreamServer
@SpringBootApplication
public class ZipkinAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinAmqpApplication.class, args);
	}
}
