package com.lsy.microserviceorders.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="goods") //以goods开头的配置被匹配到 适合获取多个属性的值
@Data
public class OrderProerties {

	private ItemProperties item = new ItemProperties();
}