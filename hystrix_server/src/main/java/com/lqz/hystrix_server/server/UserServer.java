package com.lqz.hystrix_server.server;

import com.lqz.hystrix_server.entity.SysUser;
import com.lqz.hystrix_server.vo.ResultResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * CacheResult：开启缓存，默认使所有参数作为key
     * HystrixCommand：服务降级，方法错误时走指定方法，commandKey指定key
     *
     * @return
     */
    @CacheResult()
    @HystrixCommand(fallbackMethod = "emptyList",
                                           commandKey = "list", groupKey = "UserService", threadPoolKey = "userServiceThreadPool")
    public ResultResponse list(String id) {
        List<SysUser> result = restTemplate.getForObject(userServiceUrl + "/sysUser/list", List.class);
        return new ResultResponse(result);
    }

    /**
     * CacheRemove：删除list方法的缓存
     *
     * @return
     */
    @CacheRemove(commandKey = "list")
    public ResultResponse emptyList(@PathVariable String id) {
        return new ResultResponse();
    }

}
