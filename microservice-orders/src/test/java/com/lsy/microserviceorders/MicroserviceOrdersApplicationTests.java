package com.lsy.microserviceorders;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroserviceOrdersApplicationTests {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 测试 Ribbon负载均衡
     *  默认为: 轮询
     *  还有其他方式: 随机、权重
     */
    @Test
    public void test(){
        String serviceId = "microservice-goods";
        for (int i = 0; i < 100; i++) {
            ServiceInstance serviceInstance = this.loadBalancerClient.choose(serviceId);
            System.out.println("第"+(i+1)+"次：" + serviceInstance.getHost() + ": " + serviceInstance.getPort());
        }
    }

}
