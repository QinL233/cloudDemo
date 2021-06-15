package com.lqz.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月15日 09:42:00
 */
@Configuration
public class CustomsMvcConfig implements WebMvcConfigurer {
    /**
     * 跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders("Content-Type")
                .exposedHeaders("X-Requested-With")
                .exposedHeaders("accept,Origin")
                .exposedHeaders("Access-Control-Request-Method")
                .exposedHeaders("Access-Control-Request-Headers")
                .exposedHeaders("token");
    }
}
