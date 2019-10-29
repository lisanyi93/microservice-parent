package com.lsy.microservicegoods.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品微服务 实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {
	
	private Long id;
	
	private String title;
	
	private String pic;
	
	private String desc;
	
	private Long price;

}