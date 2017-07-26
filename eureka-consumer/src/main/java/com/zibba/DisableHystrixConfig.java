package com.zibba;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * Created by liuhui on 2017/7/25.
 * 部分服务关闭hystrix
 */
public class DisableHystrixConfig {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder(){
        return Feign.builder();
    }
}
