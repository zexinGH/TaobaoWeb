package com.group2.taobao.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {

	private static DataSource dataSource = new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	
	public static Connection getConnection(){
		Connection con = tl.get();
		try {
			if(con !=null) return con;
			
			return dataSource.getConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static DataSource getDataSource(){
		
		return dataSource;
	}
	
	public static void beginTransaction() throws SQLException{
		Connection con = tl.get();
		if(con!=null) throw new SQLException("�����Ѿ���������û�н�������ʱ�������ڼ�����������");
			
		con = getConnection();
		con.setAutoCommit(false);
		tl.set(con);
	}
	
	public static void commitTransaction() throws SQLException{
		Connection con = tl.get();
		if(con==null) throw new SQLException("����û�п��������ȿ�������!");
		
		con.commit();
		con.close();
		tl.remove();
		
	}
	
	public static void rollbackTransaction() throws SQLException{
		Connection con = tl.get();
		if(con==null) throw new SQLException("����û�п��������ȿ�������!");
		
		con.rollback();
		con.close();
		tl.remove();
		
	}
	
	public static void releaseConnection(Connection connection) throws SQLException{
		Connection con = tl.get();
		if(con==null) connection.close();
		
		if(con!=connection) connection.close();
	}
}
