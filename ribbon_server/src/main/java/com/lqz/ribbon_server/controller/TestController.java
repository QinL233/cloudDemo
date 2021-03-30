package com.lqz.ribbon_server.controller;

import com.lqz.ribbon_server.entity.SysUser;
import com.lqz.ribbon_server.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author LiaoQinZhou
 * @date: 2021/3/30 10:19
 */
@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @GetMapping("/test")
    public ResultResponse test() {
        List<SysUser> result = restTemplate.getForObject(userServiceUrl + "/sysUser/list", List.class);
        return new ResultResponse(result);
    }
}
