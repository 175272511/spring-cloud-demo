package com.zibba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuhui on 2017/4/20.
 */
@RestController
public class ConsumerController {

    @Autowired
    ConsumerClient consumerClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        String name = consumerClient.sayHello("world");
        return name;
    }

    @RequestMapping("/user")
    public User user(User user){
        User user1 = consumerClient.getUser(user);
        if (user1 != null && StringUtils.isEmpty(user1.getUserId())){
            User user2 = new User();
            user2.setUserName("降级");
            return user2;
        }
        return user1;
    }

}
