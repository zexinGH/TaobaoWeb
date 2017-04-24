package com.group2.taobao.commodity.domain;

import com.group2.taobao.store.domain.Store;

public class Commodity {
	private String commodity_id;
	private String commodity_name;
	private double commodity_price;
	private String commodity_src;
	private String commodity_describe;
	private Store store;
	public String getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(String commodity_id) {
		this.commodity_id = commodity_id;
	}
	public String getCommodity_name() {
		return commodity_name;
	}
	public void setCommodity_name(String commodity_name) {
		this.commodity_name = commodity_name;
	}
	public double getCommodity_price() {
		return commodity_price;
	}
	public void setCommodity_price(double commodity_price) {
		this.commodity_price = commodity_price;
	}
	public String getCommodity_src() {
		return commodity_src;
	}
	public void setCommodity_src(String commodity_src) {
		this.commodity_src = commodity_src;
	}
	public String getCommodity_describe() {
		return commodity_describe;
	}
	public void setCommodity_describe(String commodity_describe) {
		this.commodity_describe = commodity_describe;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	
	public Commodity() {
		super();
	}
	public Commodity(String commodity_id, String commodity_name, double commodity_price,
			String commodity_src, String commodity_describe, Store store) {
		super();
		this.commodity_id = commodity_id;
		this.commodity_name = commodity_name;
		this.commodity_price = commodity_price;

		this.commodity_src = commodity_src;
		this.commodity_describe = commodity_describe;
		this.store = store;
	}
	@Override
	public String toString() {
		return "Commodity [commodity_id=" + commodity_id + ", commodity_name=" + commodity_name + ", commodity_price="
				+ commodity_price + ", commodity_src=" + commodity_src
				+ ", commodity_describe=" + commodity_describe + ", store=" + store + "]";
	}
}
