package com.lqz.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description provider dubbo application
 * @createTime 2021年06月10日 15:26:00
 */
@EnableDiscoveryClient
@EnableAutoConfiguration
public class ProviderServerApplication {
    public static void main(String[] args) {
        //仅作为微服务启动
        new SpringApplicationBuilder(ProviderServerApplication.class)
                .properties("spring.profiles.active=nacos").run(args);
    }
}
