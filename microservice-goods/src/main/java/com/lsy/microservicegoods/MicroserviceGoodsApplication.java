package com.lsy.microservicegoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient //申明Eureka客户端
@SpringBootApplication
public class MicroserviceGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceGoodsApplication.class, args);
    }

}
