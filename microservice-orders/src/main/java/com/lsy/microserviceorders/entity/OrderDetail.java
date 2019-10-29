package com.lsy.microserviceorders.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单详细 实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

	//订单Id
	private String orderId;

	//商品数据
	private Goods goods = new Goods();
}