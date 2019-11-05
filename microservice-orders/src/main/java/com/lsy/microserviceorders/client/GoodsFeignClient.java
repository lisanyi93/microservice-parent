package com.lsy.microserviceorders.client;

import com.lsy.microserviceorders.entity.Goods;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "microservice-goods") // 申明这是一个Feign客户端，并且指明服务id, 不区分大小写
public interface GoodsFeignClient {

	// 这里定义了类似于SpringMVC用法的方法，就可以进行RESTful的调用了
	//@RequestMapping(value = "/goods/{id}", method = RequestMethod.GET)
	@GetMapping(value = "/goods/{id}")
	public Goods queryGoodsById(@PathVariable("id") Long id);

	//Feign的多参数构造
	@GetMapping(value = "/goods")
	public Goods queryGoodsByList(@RequestParam("title") String title, @RequestParam("price") Long price);

	@GetMapping(value = "/goods")
	public Goods queryGoodsByList(@RequestParam Map<String,Object> params);

	@PostMapping(value = "/goods")
	public Goods addGoods(@RequestBody Map<String,Object> params);


}