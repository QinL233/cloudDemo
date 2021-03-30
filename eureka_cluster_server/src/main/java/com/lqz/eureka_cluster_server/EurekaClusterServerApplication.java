package com.lqz.eureka_cluster_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaClusterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClusterServerApplication.class, args);
    }

}
