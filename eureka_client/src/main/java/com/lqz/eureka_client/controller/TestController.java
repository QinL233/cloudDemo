package com.lqz.eureka_client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiaoQinZhou
 * @date: 2021/3/29 17:39
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "eurekaClient test";
    }
}
