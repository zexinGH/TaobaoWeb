package com.group2.taobao.order.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import com.group2.taobao.commodity.dao.CommodityDao;
import com.group2.taobao.commodity.domain.Commodity;
import com.group2.taobao.order.domain.Order;
import com.group2.taobao.order.domain.OrderItem;
import com.group2.taobao.user.dao.UserDao;
import com.group2.taobao.user.domain.User;
import com.group2.taobao.utils.CommonUtils;
import com.group2.taobao.utils.JdbcUtils;

public class OrderItemDao {

	//添加条目
	public void addOrderItem(OrderItem orderItem) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();

		String sql = "INSERT INTO order_item (order_item_id,commodity_id,order_item_count,order_item_subtotal,user_id) VALUES (?,?,?,?,?)";

		Object[] params = {orderItem.getOrder_item_id(),orderItem.getCommodity().getCommodity_id(),orderItem.getOrder_item_count(),orderItem.getOrder_item_subtotal(),orderItem.getUser().getUser_id()};
		qr.update(conn, sql, params);

		JdbcUtils.releaseConnection(conn);
	}

	//通过用户查找条目
	public List<OrderItem> findByUserId(String user_id) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		CommodityDao cdao = new CommodityDao();
		UserDao udao = new UserDao();
		List<OrderItem> list = new ArrayList<OrderItem>();

		String sql = "SELECT * FROM order_item WHERE user_id=? AND order_id is null";
		Object params = user_id;
		List<Map<String, Object>> listmap = qr.query(conn, sql,new MapListHandler(),params);
		for(int i=0;i<listmap.size();i++){
			Map map = listmap.get(i);
			OrderItem orderitem= CommonUtils.toBean(map, OrderItem.class);
			if(orderitem.getOrder_item_id()!=null){
				Commodity commodity = cdao.findById((String)map.get("commodity_id"));
				User user = udao.findById((String)map.get("user_id"));
				orderitem.setUser(user);
				orderitem.setCommodity(commodity);
				list.add(orderitem);
			}
		}
		JdbcUtils.releaseConnection(conn);
		if(list.size()!=0)
			return list;
		else
			return null;
	}

	//给条目生成订单
	public void addOrderId(Order order,List<OrderItem> orderItems) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "UPDATE order_item SET order_id=? WHERE order_item_id=?";

		for (OrderItem orderItem : orderItems) {
			Object[] params = {order.getOrder_id(),orderItem.getOrder_item_id()};
			qr.update(conn, sql, params);
		}
		JdbcUtils.releaseConnection(conn);
	}

	//通过订单编号查找条目
	public List<OrderItem> findByOrderId(String order_id) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		CommodityDao cdao = new CommodityDao();
		UserDao udao = new UserDao();
		List<OrderItem> list = new ArrayList<OrderItem>();

		String sql = "SELECT * FROM order_item WHERE order_id=?";
		Object params = order_id;

		List<Map<String,Object>> listmap = qr.query(conn, sql, new MapListHandler(), params);

		for(int i=0;i<listmap.size();i++){
			Map map = listmap.get(i);
			OrderItem orderitem= CommonUtils.toBean(map, OrderItem.class);
			if(orderitem.getOrder_item_id()!=null){
				Commodity commodity = cdao.findById((String)map.get("commodity_id"));
				User user = udao.findById((String)map.get("user_id"));
				orderitem.setUser(user);
				orderitem.setCommodity(commodity);
				list.add(orderitem);
			}
		}
		JdbcUtils.releaseConnection(conn);
		if(list.size()!=0)
			return list;
		else
			return null;
	}

	public OrderItem findById(String order_item_id) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();

		String sql = "SELECT * FROM order_item WHERE order_item_id=?";
		Object params = order_item_id;
		Map map = qr.query(conn, sql,new MapHandler(), params);
		OrderItem orderItem = CommonUtils.toBean(map, OrderItem.class);
		if(orderItem.getOrder_item_id()!=null){
			User user = CommonUtils.toBean(map, User.class);
			Commodity commodity = new CommodityDao().findById((String)map.get("commodity_id"));
			orderItem.setUser(user);
			orderItem.setCommodity(commodity);
		}else{
			JdbcUtils.releaseConnection(conn);
			return null;
		}
		JdbcUtils.releaseConnection(conn);
		return orderItem;
	}

	@Test
	public void fun1() throws SQLException{
		CommodityDao cdao = new CommodityDao();
		UserDao udao = new UserDao();
		OrderItem orderItem = new OrderItem();
		Commodity commodity = cdao.findByName("菜").get(2);
		orderItem.setOrder_item_id(CommonUtils.uuid());
		orderItem.setCommodity(commodity);
		orderItem.setOrder_item_count(2);
		orderItem.setOrder_item_subtotal(commodity.getCommodity_price()*2);
		orderItem.setUser(udao.findByName("zhonghao"));
		addOrderItem(orderItem);
	}

	@Test
	public void fun2() throws SQLException{
		List list = findByUserId("C2B6FC3E318046BBA4F4A79FACEAC96A");
		System.out.println(list);
	}

	@Test
	public void fun3() throws SQLException{
		OrderItem oi = findById("1B50DCF1A90145459E2AB6835EA29462");
		System.out.println(oi);
	}
}
