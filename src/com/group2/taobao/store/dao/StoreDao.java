package com.group2.taobao.store.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;


import com.group2.taobao.store.domain.Store;
import com.group2.taobao.user.domain.User;
import com.group2.taobao.utils.CommonUtils;
import com.group2.taobao.utils.JdbcUtils;

public class StoreDao {

	//添加店铺
	public void addStore(Store store) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();

		StringBuilder sqlBuilder = new StringBuilder("INSERT INTO store (store_id,store_name,store_address,user_id");

		List<Object> list = new ArrayList<Object>();
		list.add(store.getStore_id());
		list.add(store.getStore_name());
		list.add(store.getStore_address());
		list.add(store.getUser().getUser_id());
		int coun = 4; 
		if(store.getStore_src()!=null){
			sqlBuilder.append(",store_src");
			list.add(store.getStore_src());
			coun++;
		}
		if(store.getSotre_describe()!=null){
			sqlBuilder.append(",sotre_describe");
			list.add(store.getSotre_describe());
			coun++;
		}
		sqlBuilder.append(") VALUES (");
		for(int i=0;i<coun;i++){
			if(i<coun-1){
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

	//获得全部Store
	public List<Store> findAllStore() throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		List<Store> list = new ArrayList<Store>();
		String sql = "SELECT * FROM store";
		List<Map<String,Object>> listmap = qr.query(conn, sql, new MapListHandler());
		for(int i=0;i<listmap.size();i++){
			Map<String,Object> map = listmap.get(i);
			Store store = CommonUtils.toBean(map, Store.class);
			User user = CommonUtils.toBean(map, User.class);
			store.setUser(user);
			if(store.getStore_id()!=null)
				list.add(store);
		}
		JdbcUtils.releaseConnection(conn);
		if(list.size()!=0)
			return list;
		else
			return null;
	}

	//通过店名模糊查找
	public List<Store> findByName(String store_name) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		List<Store> list = new ArrayList<Store>();
		String sql = "SELECT * FROM store WHERE store_name LIKE ?";
		Object params = "%"+store_name+"%";
		List<Map<String,Object>> listmap = qr.query(conn, sql, new MapListHandler(), params);
		for(int i=0;i<listmap.size();i++){
			Map<String,Object> map = listmap.get(i);
			Store store = CommonUtils.toBean(map, Store.class);
			User user = CommonUtils.toBean(map, User.class);
			if(store.getStore_id()!=null){
				store.setUser(user);
				list.add(store);
			}
		}
		JdbcUtils.releaseConnection(conn);
		if(list.size()!=0)
			return list;
		else
			return null;

	}

	//通过ID精确查找
	public Store findById(String sotre_id) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM store WHERE store_id=?";
		Object params = sotre_id;
		Map<String, Object> map = qr.query(conn, sql, new MapHandler(), params);
		Store store = CommonUtils.toBean(map, Store.class);
		User user = CommonUtils.toBean(map, User.class);

		JdbcUtils.releaseConnection(conn);
		if(store.getStore_id()!=null)
		{
			store.setUser(user);
			return store;
		}else
			return null;
	}

}
