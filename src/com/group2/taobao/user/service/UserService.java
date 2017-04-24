package com.group2.taobao.user.service;

import java.sql.SQLException;

import com.group2.taobao.user.dao.UserDao;
import com.group2.taobao.user.domain.User;

public class UserService {

	UserDao dao = new UserDao();
	
	public User login(String user_name,String user_password){
		try {
			User user = dao.findByName(user_name);
			if(user==null) return null;
			if(!user.getUser_password().equals(user_password)) return null;
			return user;
		} catch (SQLException e) {
			return null;
		}
	}
	
	public boolean register(User user){
		try {
			if(dao.findByName(user.getUser_name())!=null) return false;
			dao.addUser(user);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean updateUser(User user){
		try {
			User user2 = dao.findByName(user.getUser_name());
			if(user2!=null && !user2.getUser_id().equals(user.getUser_id()))
				return false;
			if(user.getUser_name() == null||user.getUser_password() == null||user.getUser_name().trim().isEmpty()||user.getUser_password().trim().isEmpty())
				return false;
			System.out.println(1);
			dao.updateUser(user);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}
