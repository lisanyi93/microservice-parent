package com.lsy.microserviceorders.service;

import com.lsy.microserviceorders.entity.Goods;
import com.lsy.microserviceorders.entity.Order;
import com.lsy.microserviceorders.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 订单 业务层
 */
@Service
public class OrderService {

	private static final Map<String, Order> MAP = new HashMap<String, Order>();

	static {
		//订单数据
		Order order = new Order();
		order.setOrderId("59193738268961441");
		order.setCreateDate(new Date());
		order.setUpdateDate(order.getCreateDate());
		order.setUserId(1L);

		//订单详细数据
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		Goods goods = new Goods();// 此处并没有商品的数据，需要调用商品微服务获取
		goods.setId(1L);
		orderDetails.add(new OrderDetail(order.getOrderId(), goods));

		goods = new Goods(); // 构造第二个商品数据
		goods.setId(2L);
		orderDetails.add(new OrderDetail(order.getOrderId(), goods));

		order.setOrderDetails(orderDetails);

		MAP.put(order.getOrderId(), order);
	}

	@Autowired
	private GoodsService goodsService;

	/**
	 * 根据订单id查询订单数据
	 * 
	 * @param orderId
	 * @return
	 */
	public Order queryOrderById(String orderId) {
		Order order = MAP.get(orderId);
		if (null == order) {
			return null;
		}
		List<OrderDetail> orderDetails = order.getOrderDetails();
		for (OrderDetail orderDetail : orderDetails) {
			// 通过商品微服务查询商品数据
			Goods goods = this.goodsService.queryGoodsById(orderDetail.getGoods().getId());
			if (null == goods) {
				continue;
			}
			orderDetail.setGoods(goods);
		}

		return order;
	}
}