package com.group2.taobao.commodity.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import com.group2.taobao.commodity.domain.Commodity;
import com.group2.taobao.store.dao.StoreDao;
import com.group2.taobao.store.domain.Store;
import com.group2.taobao.utils.CommonUtils;
import com.group2.taobao.utils.JdbcUtils;

public class CommodityDao {

	//添加商品
	public void addCommodity(Commodity commodity) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();

		StringBuilder sqlBuilder = new StringBuilder("INSERT INTO commodity (commodity_id,commodity_name,commodity_price,store_id");

		List<Object> list = new ArrayList<Object>();
		list.add(commodity.getCommodity_id());
		list.add(commodity.getCommodity_name());
		list.add(commodity.getCommodity_price());
		list.add(commodity.getStore().getStore_id());

		int coun = 4; 
		if(commodity.getCommodity_src()!=null){
			sqlBuilder.append(",commodity_src");
			list.add(commodity.getCommodity_src());
			coun++;
		}
		if(commodity.getCommodity_describe()!=null){
			sqlBuilder.append(",commodity_describe");
			list.add(commodity.getCommodity_describe());
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

	//查找所有商品
	public List<Commodity> findAllCommodity() throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();

		List<Commodity> list = new ArrayList<Commodity>();

		String sql = "SELECT * FROM commodity";
		List<Map<String,Object>> listmap = qr.query(conn, sql, new MapListHandler());
		for(int i=0;i<listmap.size();i++){
			Map<String,Object> map = listmap.get(i);
			Commodity commodity = CommonUtils.toBean(map, Commodity.class);
			Store store = CommonUtils.toBean(map, Store.class);

			if(commodity.getCommodity_id()!=null)
			{
				commodity.setStore(store);
				list.add(commodity);
			}
		}
		JdbcUtils.releaseConnection(conn);
		if(list.size()!=0)
			return list;
		else
			return null;
	}

	public List<Commodity> findByName(String commodity_name) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		StoreDao dao = new StoreDao();

		List<Commodity> list = new ArrayList<Commodity>();

		String sql = "SELECT * FROM commodity WHERE commodity_name LIKE ?";
		Object params = "%"+commodity_name+"%";

		List<Map<String,Object>> listmap = qr.query(conn, sql, new MapListHandler(), params);

		for(int i=0;i<listmap.size();i++){
			Map<String,Object> map = listmap.get(i);
			Commodity commodity = CommonUtils.toBean(map, Commodity.class);
			Store store = CommonUtils.toBean(map, Store.class);
			Store store2 = dao.findById(store.getStore_id());
			if(commodity.getCommodity_id()!=null)
			{
				commodity.setStore(store2);
				list.add(commodity);
			}
		}
		JdbcUtils.releaseConnection(conn);
		if(list.size()!=0)
			return list;
		else
			return null;

	}

	public Commodity findById(String commodity_id) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM commodity WHERE commodity_id=?";
		Object params = commodity_id;
		Map<String, Object> map = qr.query(conn, sql, new MapHandler(), params);
		Commodity commodiyt = CommonUtils.toBean(map, Commodity.class);
		Store store = CommonUtils.toBean(map, Store.class);
		Store store2 = new StoreDao().findById(store.getStore_id());
		
		JdbcUtils.releaseConnection(conn);
		if(commodiyt.getCommodity_id()!=null)
		{
			commodiyt.setStore(store2);
			return commodiyt;
		}
		else
			return null;

	}

	@Test
	public void fun1() throws SQLException{
		Commodity commodity = new Commodity();
		commodity.setCommodity_id(CommonUtils.uuid());
		commodity.setCommodity_name("北京梅菜");
		commodity.setCommodity_price(20.00);
		commodity.setStore(new StoreDao().findByName("梅菜店").get(0));
		addCommodity(commodity);
	}

	@Test
	public void fun2() throws SQLException{
		List<Commodity> list = findAllCommodity();
		System.out.println(list);
	}
	
}
