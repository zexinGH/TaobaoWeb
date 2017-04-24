package com.group2.taobao.commodity.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.group2.taobao.commodity.domain.CommodityStyle;
import com.group2.taobao.utils.CommonUtils;
import com.group2.taobao.utils.JdbcUtils;

public class CommodityStyleDao {

	//添加样式
	public void addCommodityStyle(CommodityStyle commodityStyle) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		
		String sql = "INSERT INTO commodity_style VALUES (?,?,?)";	
		Object[] params = {commodityStyle.getCommodity_style_id(),commodityStyle.getCommodity_style_color(),commodityStyle.getCommodity_style_size()};
		
		qr.update(conn, sql, params);
		
		JdbcUtils.releaseConnection(conn);
		
	}
	
	//通过id查找样式
	public CommodityStyle findById(String commodity_style_id) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		
		String sql = "SELECT * FROM commodity_style WHERE commodity_style_id=?";
		Object params = commodity_style_id;
		
		CommodityStyle commodityStyle = qr.query(conn, sql, new BeanHandler<CommodityStyle>(CommodityStyle.class), params);
		
		return commodityStyle;
		
	}
	
	@Test
	public void fun1() throws SQLException{
		CommodityStyle commdityStyle = new CommodityStyle();
		commdityStyle.setCommodity_style_id(CommonUtils.uuid());
		commdityStyle.setCommodity_style_color("白色");
		commdityStyle.setCommodity_style_size(17);
		addCommodityStyle(commdityStyle);
	}
	
	@Test
	public void fun2() throws SQLException{
		CommodityStyle commodityStyle = findById("8AB54F0B1CE848A496FE6552B4311E42");
		System.out.println(commodityStyle);
	}
}
