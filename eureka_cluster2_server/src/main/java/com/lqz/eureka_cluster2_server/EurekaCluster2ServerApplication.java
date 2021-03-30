package com.lqz.eureka_cluster2_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaCluster2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaCluster2ServerApplication.class, args);
    }

}
