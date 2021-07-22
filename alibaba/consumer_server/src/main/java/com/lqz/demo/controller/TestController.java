package com.lqz.demo.controller;

import com.lqz.demo.service.TestService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月22日 15:27:00
 */
@RestController
@CrossOrigin
@RequestMapping("/test")
public class TestController {

    @DubboReference
    private TestService testService;

    @GetMapping
    public String save(Boolean flag) {
        return testService.test(flag);
    }
}
