package com.lsy.microserviceorders.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Exclusive Copyright</p>
 *
 * @author lisanyi
 * @version 1.0
 * @Description：
 * @Date: Created in 2019­10­22 10:52
 */
@Component
public class RestTemplateConfig {

    /**
     * RestTemplate 底层默认使用的jdk的标准实现
     * @return
     */
    @Bean
    @LoadBalanced //开启负载均衡
    public RestTemplate restTemplateByJdk(){
        return new RestTemplate();
    }


    //这里配置策略，和配置文件对应。默认是轮询的
    @Bean
    public IRule ribbonRule() {
        return new RandomRule(); //这里配置随机策略
    }

    /**
     * RestTemplate OkHttp的实现方式
     * @return
     */
    /* @Bean
    public RestTemplate restTemplateByOkHttp(){
        //构造requestFactory
        OkHttp3ClientHttpRequestFactory requestFactory = new OkHttp3ClientHttpRequestFactory();
        requestFactory.setConnectTimeout(60*1000);
        requestFactory.setReadTimeout(60*1000);

        //构造restTemplate 传入OKhttp的requestFactory
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }*/
}
