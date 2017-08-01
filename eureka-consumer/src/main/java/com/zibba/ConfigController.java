package com.zibba;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuhui on 2017/7/27.
 */
@RefreshScope
@RestController
public class ConfigController {

    @Value("${from}")
    private String from;

    @Value("${common}")
    private String common;

    @RequestMapping("/from")
    public String from(){
        System.out.println(">>>" + common);
        return this.from;
    }
}
