package com.zibba;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuhui on 2017/4/20.
 */
@Api(value = "测试文档", description = "描述文档")
@RestController
public class ConsumerController {

    @Autowired
    ConsumerClient consumerClient;

    @ApiOperation(notes = "测试接口", value = "测试")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        String name = consumerClient.sayHello("world");
        return name;
    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public String hello1(@PathVariable String name) {
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
