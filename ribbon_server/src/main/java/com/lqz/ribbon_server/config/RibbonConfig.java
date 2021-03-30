package com.lqz.ribbon_server.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author LiaoQinZhou
 * @date: 2021/3/30 10:15
 */
@Configuration
public class RibbonConfig {

    /**
     * 加载负载均衡bean
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
