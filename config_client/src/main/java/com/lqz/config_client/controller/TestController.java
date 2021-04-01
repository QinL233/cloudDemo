package com.lqz.config_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiaoQinZhou
 * @date: 2021/3/31 11:35
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${test.config.info}")
    private String config_info;

    @GetMapping("/getConfigInfo")
    public String getConfigInfo(){
        return config_info;
    }
}
