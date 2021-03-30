package com.lqz.hystrix_server.server;

import com.lqz.hystrix_server.entity.SysUser;
import com.lqz.hystrix_server.vo.ResultResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author LiaoQinZhou
 * @date: 2021/3/30 11:03
 */
@Service
public class UserServer {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @HystrixCommand(fallbackMethod = "empty")
    public ResultResponse list() {
        List<SysUser> result = restTemplate.getForObject(userServiceUrl + "/sysUser/list", List.class);
        return new ResultResponse(result);
    }

    public ResultResponse empty() {
        return new ResultResponse();
    }

}
