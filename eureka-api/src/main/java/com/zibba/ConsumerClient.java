package com.zibba;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by liuhui on 2017/4/20.
 */
public interface ConsumerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String sayHello(@RequestParam(value = "name") String name);

    @RequestMapping("/user")
    User getUser(@RequestBody User user);
}
