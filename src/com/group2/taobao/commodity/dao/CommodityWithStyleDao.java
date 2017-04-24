package com.group2.taobao.commodity.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.junit.Test;

import com.group2.taobao.commodity.domain.Commodity;
import com.group2.taobao.commodity.domain.CommodityStyle;
import com.group2.taobao.commodity.domain.CommodityWithStyle;
import com.group2.taobao.utils.CommonUtils;
import com.group2.taobao.utils.JdbcUtils;

public class CommodityWithStyleDao {

	//添加某种商品某种样式的数量
	public void addCommodityWithStyle(CommodityWithStyle commodityWithStyle) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();

		String sql = "INSERT INTO commodity_with_style VALUES(?,?,?,?)";
		Object[] params = {commodityWithStyle.getCommodity_with_style_id(),
				commodityWithStyle.getCommodity().getCommodity_id(),
				commodityWithStyle.getCommodity_style().getCommodity_style_id(),
				commodityWithStyle.getCommodity_with_sum()};

		qr.update(conn, sql, params);
		JdbcUtils.releaseConnection(conn);
	}

	//通过Id获取某种样式的某种商品的数量表
	public CommodityWithStyle findById(String commodity_with_style_id) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();

		String sql = "SELECT * FROM commodity_with_style WHERE commodity_with_style_id=?";
		Object params = commodity_with_style_id;
		Map<String, Object> map = qr.query(conn, sql, new MapHandler(), params);

		CommodityWithStyle commodityWithStyle = CommonUtils.toBean(map,CommodityWithStyle.class);
		Commodity commodity = CommonUtils.toBean(map, Commodity.class);
		CommodityStyle commodityStyle = CommonUtils.toBean(map, CommodityStyle.class);

		JdbcUtils.releaseConnection(conn);
		if(commodityWithStyle.getCommodity_with_style_id()!=null)
		{
			commodityWithStyle.setCommodity(commodity);
			commodityWithStyle.setCommodity_style(commodityStyle);
			return commodityWithStyle;
		}
		else
			return null;
	}

	//通过商品Id获取某种样式的该种商品的数量表
	public CommodityWithStyle findByCommodityId(String commodity_id) throws SQLException{
		
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();

		String sql = "SELECT * FROM commodity_with_style WHERE commodity_id=?";
		Object params = commodity_id;
		Map<String, Object> map = qr.query(conn, sql, new MapHandler(), params);

		CommodityWithStyle commodityWithStyle = CommonUtils.toBean(map,CommodityWithStyle.class);
		Commodity commodity = CommonUtils.toBean(map, Commodity.class);
		CommodityStyle commodityStyle = CommonUtils.toBean(map, CommodityStyle.class);

		JdbcUtils.releaseConnection(conn);
		if(commodityWithStyle.getCommodity_with_style_id()!=null)
		{
			commodityWithStyle.setCommodity(commodity);
			commodityWithStyle.setCommodity_style(commodityStyle);
			return commodityWithStyle;
		}
		else
			return null;
	}

	@Test
	public void fun1() throws SQLException{
		CommodityWithStyle commodityWithStyle = new CommodityWithStyle();
		commodityWithStyle.setCommodity_with_style_id(CommonUtils.uuid());
		commodityWithStyle.setCommodity(new CommodityDao().findByName("平远梅菜").get(0));
		commodityWithStyle.setCommodity_style(new CommodityStyleDao().findById("953BB76BC1A14575961EA1CC72C06434"));
		commodityWithStyle.setCommodity_with_sum(70);
		addCommodityWithStyle(commodityWithStyle);
		
	}
}
