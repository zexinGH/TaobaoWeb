package com.group2.taobao.order.domain;

import java.sql.Date;
import java.util.List;

import com.group2.taobao.user.domain.User;

public class Order {
	private String order_id;
	private Date order_time;
	private double order_total;
	private String order_address;
	private User user;
	public List<OrderItem> getOrderItems() {
		return OrderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		OrderItems = orderItems;
	}
	private List<OrderItem> OrderItems;
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public double getOrder_total() {
		return order_total;
	}
	public void setOrder_total(double order_total) {
		this.order_total = order_total;
	}
	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_time=" + order_time + ", order_total=" + order_total
				+ ", order_address=" + order_address + ", user=" + user + ", OrderItems=" + OrderItems + "]";
	}
	public Order(String order_id, Date order_time, double order_total, String order_address, User user,
			List<OrderItem> orderItems) {
		super();
		this.order_id = order_id;
		this.order_time = order_time;
		this.order_total = order_total;
		this.order_address = order_address;
		this.user = user;
		OrderItems = orderItems;
	}
	public Order() {
		super();
	}
}
