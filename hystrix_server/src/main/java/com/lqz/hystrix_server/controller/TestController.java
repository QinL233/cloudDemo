package com.lqz.hystrix_server.controller;

import com.lqz.hystrix_server.server.UserServer;
import com.lqz.hystrix_server.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiaoQinZhou
 * @date: 2021/3/30 10:59
 */
@RestController
public class TestController {

    @Autowired
    private UserServer userServer;

    @GetMapping("/test/{id}")
    public ResultResponse test(@PathVariable String id) {
        return userServer.list(id);
    }
}
