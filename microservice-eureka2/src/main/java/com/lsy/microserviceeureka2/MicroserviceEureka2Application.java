package com.lsy.microserviceeureka2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer //申明这是一个Eureka服务端
@SpringBootApplication
public class MicroserviceEureka2Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceEureka2Application.class, args);
    }

}
