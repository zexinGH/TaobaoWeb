package com.group2.taobao.user.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.group2.taobao.user.domain.User;
import com.group2.taobao.utils.CommonUtils;
import com.group2.taobao.utils.JdbcUtils;

public class UserDao {
	
	//通过用户名查找
	public User findByName(String user_name) throws SQLException{
		
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM user WHERE user_name=?";
		User user = qr.query(conn, sql, new BeanHandler<User>(User.class),user_name);
		JdbcUtils.releaseConnection(conn);
		return user;
	}
	
	//通过ID查找
	public User findById(String user_id) throws SQLException{
		
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM user WHERE user_id=?";
		User user = qr.query(conn, sql, new BeanHandler<User>(User.class),user_id);
		JdbcUtils.releaseConnection(conn);
		return user;
	}
	
	//添加User
	public void addUser(User user) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		List<Object> list = new ArrayList<Object>();
		list.add(user.getUser_id());
		list.add(user.getUser_name());
		list.add(user.getUser_password());
		list.add(user.getUser_level());
		int i = 4;
		StringBuilder sqlBuilder = new StringBuilder("INSERT INTO user (user_id,user_name,user_password,user_level");
		//判断用户注册时，输入了那些信息
		if(user.getUser_address()!=null && !user.getUser_address().trim().isEmpty()){
			sqlBuilder.append(",user_address");
			list.add(user.getUser_address());
			i++;
		}
		if(user.getUser_gender()!=null && !user.getUser_gender().trim().isEmpty()){
			sqlBuilder.append(",user_gender");
			list.add(user.getUser_gender());
			i++;
		}
		sqlBuilder.append(") VALUES (");
		for(int j=0;j<i;j++){
			if(j<i-1){
				sqlBuilder.append("?,");
			}else{
				sqlBuilder.append("?)");
			}
		}
		String sql = sqlBuilder.toString();
		Object[] params = list.toArray();
		qr.update(conn, sql, params);
		JdbcUtils.releaseConnection(conn);
	}
	
	//更新用户信息
	public void updateUser(User user) throws SQLException{
		
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		
		List<Object> list = new ArrayList<Object>();
		list.add(user.getUser_name());
		list.add(user.getUser_password());
		
		StringBuilder sqlBuilder = new StringBuilder("UPDATE user SET user_name=?,user_password=?");
		
		if(user.getUser_gender()!=null && !user.getUser_gender().trim().isEmpty()){
			sqlBuilder.append(",user_gender=?");
			list.add(user.getUser_gender());
		}
		if(user.getUser_address()!=null && !user.getUser_address().trim().isEmpty()){
			sqlBuilder.append(",user_address=?");
			list.add(user.getUser_address());
		}
		
		sqlBuilder.append(" WHERE user_id=?");
		list.add(user.getUser_id());
		
		String sql = sqlBuilder.toString();
		Object[] params = list.toArray();
		qr.update(conn, sql, params);
		JdbcUtils.releaseConnection(conn);
			
	}
	
	@Test
	public void fun1() throws SQLException{
		User user  = new User();
		user.setUser_id(CommonUtils.uuid());
		user.setUser_name("zhongHao");
		user.setUser_password("123456");
		user.setUser_level(1);
		user.setUser_address("hahahha");
		addUser(user);
	}
	
	@Test
	public void fun2() throws SQLException{
		User user = findByName("zhonghao");
		System.out.println(user);
	}
	
	@Test
	public void fun3() throws SQLException{
		User user = new User();
		user.setUser_name("zhonghao");
		user.setUser_password("826256645");
		user.setUser_id("C2B6FC3E318046BBA4F4A79FACEAC96A");
		user.setUser_gender("male");
		updateUser(user);
	}
}
