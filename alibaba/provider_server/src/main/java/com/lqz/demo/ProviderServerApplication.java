package com.lqz.demo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description provider dubbo application
 * @createTime 2021年06月10日 15:26:00
 */
@SpringBootApplication
public class ProviderServerApplication {
    public static void main(String[] args) {
        //仅作为微服务启动
        new SpringApplicationBuilder(ProviderServerApplication.class).web(WebApplicationType.NONE).run(args);
    }
}
