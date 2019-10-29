package com.lsy.microservicegoods.controller;


import com.lsy.microservicegoods.config.JdbcConfigBean;
import com.lsy.microservicegoods.entity.Goods;
import com.lsy.microservicegoods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private JdbcConfigBean jdbcConfigBean;

	/**
	 * 对外提供接口服务，查询商品信息
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "goods/{id}")
	public Goods queryGoodsById(@PathVariable("id") Long id) {
		return this.goodsService.queryGoodsById(id);
	}


	@GetMapping(value = "test")
	public String test(){
		return this.jdbcConfigBean.toString();
	}

}