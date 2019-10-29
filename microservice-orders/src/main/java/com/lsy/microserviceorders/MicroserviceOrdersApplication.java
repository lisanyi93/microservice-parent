package com.lsy.microserviceorders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableFeignClients //开启Feign注解
@EnableHystrix //开启容错机制注解
@EnableDiscoveryClient //申明Eureka客户端
@SpringBootApplication
public class MicroserviceOrdersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceOrdersApplication.class, args);
    }

}
