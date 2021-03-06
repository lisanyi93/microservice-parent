package com.lsy.microserviceorders.controller;

import com.lsy.microserviceorders.entity.Order;
import com.lsy.microserviceorders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单Controller
 */
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping(value = "orders/{orderId}")
	public Order queryOrderById(@PathVariable("orderId") String orderId) {
		return this.orderService.queryOrderById(orderId);
	}

}