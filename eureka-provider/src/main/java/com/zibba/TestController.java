package com.zibba;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by liuhui on 2017/4/20.
 */
@RestController
public class TestController implements ConsumerClient {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private Registration registration;

    @Override
    public String sayHello(String name){
        ServiceInstance instances = discoveryClient.getLocalServiceInstance();
        String host = instances.getHost();
        logger.info("/hello, host:" + host + ", service_id:" + instances.getServiceId());
//        logger.info("serviceId:" + registration.getServiceId());
        return "hello, " + name;
    }

    @Override
    public User getUser(@RequestBody User user) {
        logger.info("/getUser");
        try {
            Thread.sleep(999999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }
}
