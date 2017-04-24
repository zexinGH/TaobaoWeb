package com.group2.taobao.user.domain;

public class User {
	private String user_id;
	private String user_name;
	private String user_password;
	private String user_gender;
	private int user_level;
	private String user_src;
	private String user_address;
	private double money;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public int getUser_level() {
		return user_level;
	}
	public void setUser_level(int user_level) {
		this.user_level = user_level;
	}
	public String getUser_src() {
		return user_src;
	}
	public void setUser_src(String user_src) {
		this.user_src = user_src;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	public User() {
		super();
	}
	public User(String user_id, String user_name, String user_password, String user_gender, int user_level,
			String user_src, String user_address, double money) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_gender = user_gender;
		this.user_level = user_level;
		this.user_src = user_src;
		this.user_address = user_address;
		this.money = money;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", user_gender=" + user_gender + ", user_level=" + user_level + ", user_src=" + user_src
				+ ", user_address=" + user_address + ", money=" + money + "]";
	}
	
	
}
