package com.group2.taobao.user.service;

import java.sql.SQLException;

import com.group2.taobao.user.dao.UserDao;
import com.group2.taobao.user.domain.User;

public class AjaxService {
	UserDao userdao = new UserDao();
	
	public boolean verifyUsername(String user_name){
		try {
			User user = userdao.findByName(user_name);
			if(user!=null) return false;
			return true;
		} catch (SQLException e) {
			return false;
		}
	} 
}
