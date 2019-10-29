package com.lsy.microserviceorders.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 订单 实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	private String orderId;

	private Long userId;

	private Date createDate;

	private Date updateDate;

	//订单详细
	private List<OrderDetail> orderDetails;
}