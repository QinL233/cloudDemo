package com.lqz.hystrix_server.controller;

import com.lqz.hystrix_server.entity.SysUser;
import com.lqz.hystrix_server.server.UserServer;
import com.lqz.hystrix_server.vo.ResultResponse;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author LiaoQinZhou
 * @date: 2021/3/30 10:59
 */
@RestController
public class TestController {

    @Autowired
    private UserServer userServer;

    @GetMapping("/test")
    public ResultResponse test() {
        return userServer.list();
    }
}
