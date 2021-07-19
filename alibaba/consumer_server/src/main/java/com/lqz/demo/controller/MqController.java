package com.lqz.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月18日 11:54:00
 */
@RestController
@CrossOrigin
@RequestMapping("/mq")
public class MqController {

    @Autowired
    StreamBridge streamBridge;

    @GetMapping("/test1")
    public void test1(String msg) {
        //发送到指定的topic中
        streamBridge.send("test1", msg);
    }

    @GetMapping("/test2")
    public void test2(String msg) {
        //发送到指定的topic中
        streamBridge.send("test2", msg);
    }
}
