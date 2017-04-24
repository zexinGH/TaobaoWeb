package com.group2.taobao.order.service;

import java.sql.SQLException;
import java.util.List;

import com.group2.taobao.order.dao.OrderItemDao;
import com.group2.taobao.order.domain.OrderItem;
import com.group2.taobao.utils.CommonUtils;

public class OrderItemService {

	OrderItemDao dao = new OrderItemDao();
	
	public boolean addShopCar(OrderItem orderItem){
		try {
			dao.addOrderItem(orderItem);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public List<OrderItem> getMyOrderItem(String user_id) {
		try {
			List<OrderItem> list = dao.findByUserId(user_id);
			return list;
		} catch (SQLException e) {
			return null;
		}
		
	}
}
