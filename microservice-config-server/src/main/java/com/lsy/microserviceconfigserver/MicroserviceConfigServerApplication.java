package com.lsy.microserviceconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableDiscoveryClient //申明Eureka客户端
@EnableConfigServer //开启配置服务
@SpringBootApplication
public class MicroserviceConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConfigServerApplication.class, args);
    }

}
