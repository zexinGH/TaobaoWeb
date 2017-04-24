package com.group2.taobao.store.domain;

import com.group2.taobao.user.domain.User;

public class Store {
	private String store_id;
	private String store_name;
	private String store_address;
	private String store_src;
	private String sotre_describe;
	private User user;
	public String getStore_id() {
		return store_id;
	}
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getStore_address() {
		return store_address;
	}
	public void setStore_address(String store_address) {
		this.store_address = store_address;
	}
	public String getStore_src() {
		return store_src;
	}
	public void setStore_src(String store_src) {
		this.store_src = store_src;
	}
	public String getSotre_describe() {
		return sotre_describe;
	}
	public void setSotre_describe(String sotre_describe) {
		this.sotre_describe = sotre_describe;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Store(String store_id, String store_name, String store_address, String store_src, String sotre_describe,
			User user) {
		super();
		this.store_id = store_id;
		this.store_name = store_name;
		this.store_address = store_address;
		this.store_src = store_src;
		this.sotre_describe = sotre_describe;
		this.user = user;
	}
	public Store() {
		super();
	}
	
	@Override
	public String toString() {
		return "Store [store_id=" + store_id + ", store_name=" + store_name + ", store_address=" + store_address
				+ ", store_src=" + store_src + ", sotre_describe=" + sotre_describe + ", user=" + user + "]";
	}
}
