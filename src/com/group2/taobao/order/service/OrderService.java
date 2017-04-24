package com.group2.taobao.order.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.group2.taobao.order.dao.OrderDao;
import com.group2.taobao.order.dao.OrderItemDao;
import com.group2.taobao.order.domain.Order;
import com.group2.taobao.order.domain.OrderItem;
import com.group2.taobao.user.domain.User;
import com.group2.taobao.utils.CommonUtils;
import com.group2.taobao.utils.JdbcUtils;

public class OrderService {

	OrderDao odao = new OrderDao();
	OrderItemDao oIdao = new OrderItemDao();
	public boolean createOrder(String[] order_item_ids,User user) {

		boolean state = false;

		java.util.Date utilDate = new Date();      
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());  

		Order order = new Order();
		order.setOrder_id(CommonUtils.uuid());
		order.setUser(user);
		order.setOrder_address(user.getUser_address());
		order.setOrder_time(sqlDate);
		double sum = 0;
		List<OrderItem> list = new ArrayList<>();
		try {
			JdbcUtils.beginTransaction();
			for(int i=0;i<order_item_ids.length;i++){
				String order_item_id = order_item_ids[i];
				OrderItem orderItem = oIdao.findById(order_item_id);
				list.add(orderItem);
				sum = sum+orderItem.getCommodity().getCommodity_price();
			}
			order.setOrder_total(sum);
			//先创建订单表
			odao.addOrder(order);
			//在添加order_id;
			oIdao.addOrderId(order, list);
			state=true;
		} catch (SQLException e) {
			e.printStackTrace();
			state=false;
		}finally{
			try {
				JdbcUtils.commitTransaction();
				return state;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return state;
	}


	@Test
	public void fun1(){
		java.util.Date utilDate = new Date();      
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());   
		System.out.println(sqlDate);
	}
}
