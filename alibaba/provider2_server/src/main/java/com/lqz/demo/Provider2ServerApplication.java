package com.lqz.demo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月17日 17:39:00
 */
@SpringBootApplication
public class Provider2ServerApplication {
    public static void main(String[] args) {
        //仅作为微服务启动
        new SpringApplicationBuilder(Provider2ServerApplication.class).web(WebApplicationType.NONE).run(args);
    }
}
