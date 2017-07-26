package com.zibba;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by liuhui on 2017/4/20.
 * 降级处理
 */
@Component
public class ConsumerClientHystrix implements FeignConsumerClient {

    @Override
    public String sayHello(@RequestParam(value = "name") String name) {
        return "error";
    }

    @Override
    public User getUser(@RequestBody User user) {
        return new User();
    }
}
