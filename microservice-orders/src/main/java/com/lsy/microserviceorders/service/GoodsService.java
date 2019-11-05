package com.lsy.microserviceorders.service;

import com.lsy.microserviceorders.client.GoodsFeignClient;
import com.lsy.microserviceorders.entity.Goods;
import com.lsy.microserviceorders.properties.OrderProerties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 商品微服务
 */
@Service
public class GoodsService {

	// Spring框架对RESTful方式的http请求做了封装，来简化操作
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;

	//获取配置文件里面的值 只适合获取单个值
	@Value("${goods.item.url}")
	private String goodsItemUrl;

	//适用于获取多个值
	@Autowired
	private OrderProerties proerties;

	//方式1：通过RestTemplate方式
/*	public Goods queryGoodsById(Long id) {
		return this.restTemplate.getForObject(proerties.getItem().getUrl() + id, Goods.class);
	}*/


	//方式2：从Eureka注册中心 获取商品微服务
/*	public Goods queryGoodsById(Long id) {
		//通过服务Id获取商品微服务
		String serviceId = "microservice-goods";
		//服务可能是集群的 所以多个实例
		List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);
		if(instances.isEmpty()){
			return null;
		}

		// 为了演示，在这里只获取一个实例
		ServiceInstance serviceInstance = instances.get(0);
		String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
		return this.restTemplate.getForObject("http://" + url + "/goods/" + id, Goods.class);
	}*/

	//方式2: 优化
/*	public Goods queryGoodsById(Long id) {
		//通过服务Id获取商品微服务 大小写不区分
		String serviceId = "MICROSERVICE-GOODS";
		return this.restTemplate.getForObject("http://" + serviceId + "/goods/" + id, Goods.class);
	}*/

	//方式2优化后: 加入hystrix容错机制
/*	@HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod") // 进行容错处理
	public Goods queryGoodsById(Long id) {
		String serviceId = "microservice-goods";
		return this.restTemplate.getForObject("http://" + serviceId + "/goods/" + id, Goods.class);
	}*/


	//方式3: Feign调用服务
	@Autowired
	private GoodsFeignClient goodsFeignClient;

	@HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod") // 进行容错处理
	public Goods queryGoodsById(Long id) {
		Goods goods = this.goodsFeignClient.queryGoodsById(id);
		if(goods != null){
			return goods;
		}
		return new Goods(id, "查询商品信息不存在!", null, null, null);
	}


	/**
	 * 容错机制 返回信息
	 * @param id
	 * @return
	 */
	public Goods queryItemByIdFallbackMethod(Long id){ // 请求失败执行的方法
		return new Goods(id, "查询商品信息出错!", null, null, null);
	}
}
