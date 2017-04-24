package com.group2.taobao.order.domain;

import com.group2.taobao.commodity.domain.Commodity;
import com.group2.taobao.user.domain.User;

public class OrderItem {
	private String order_item_id;
	private Commodity commodity;
	private int order_item_count;
	private double order_item_subtotal;
	private Order order;
	private User user;

	public String getOrder_item_id() {
		return order_item_id;
	}

	public void setOrder_item_id(String order_item_id) {
		this.order_item_id = order_item_id;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public int getOrder_item_count() {
		return order_item_count;
	}

	public void setOrder_item_count(int order_item_count) {
		this.order_item_count = order_item_count;
	}

	public double getOrder_item_subtotal() {
		return order_item_subtotal;
	}

	public void setOrder_item_subtotal(double order_item_subtotal) {
		this.order_item_subtotal = order_item_subtotal;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public OrderItem() {
		super();
	}

	public OrderItem(String order_item_id, Commodity commodity, int order_item_count, double order_item_subtotal,
			Order order, User user) {
		super();
		this.order_item_id = order_item_id;
		this.commodity = commodity;
		this.order_item_count = order_item_count;
		this.order_item_subtotal = order_item_subtotal;
		this.order = order;
		this.user = user;
	}

	@Override
	public String toString() {
		return "OrderItem [order_item_id=" + order_item_id + ", commodity=" + commodity + ", order_item_count="
				+ order_item_count + ", order_item_subtotal=" + order_item_subtotal + ", order=" + order + ", user="
				+ user + "]";
	}


	
}
