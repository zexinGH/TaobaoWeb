package com.group2.taobao.order.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.group2.taobao.commodity.domain.Commodity;
import com.group2.taobao.order.domain.Order;
import com.group2.taobao.order.domain.OrderItem;
import com.group2.taobao.user.dao.UserDao;
import com.group2.taobao.user.domain.User;
import com.group2.taobao.utils.CommonUtils;
import com.group2.taobao.utils.JdbcUtils;

public class OrderDao {

	//生成订单
	public void addOrder(Order order) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "INSERT INTO `order` VALUES (?,?,?,?,?)";
		Object[] params={order.getOrder_id(),
				order.getOrder_time(),
				order.getOrder_total(),
				order.getOrder_address(),
				order.getUser().getUser_id()};
		qr.update(conn, sql, params);
		JdbcUtils.releaseConnection(conn);
	}
	
	//根据用户名读取其订单
	public List<Order> findByUserId(String user_id) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		List<Order> list = new ArrayList<Order>();
		OrderItemDao oIdao = new OrderItemDao();
		UserDao udao = new UserDao();
		
		String sql = "SELECT * FROM order WHERE user_id=?";
		Object params = user_id;
		
		List<Map<String,Object>> listmap = qr.query(conn, sql, new MapListHandler(), params);
		
		for(int i=0;i<listmap.size();i++){
			Map map = listmap.get(i);
			Order order= CommonUtils.toBean(map, Order.class);
			if(order.getOrder_id()!=null){
				User user = udao.findById((String)map.get("user_id"));
				List<OrderItem> oIlist = oIdao.findByOrderId(order.getOrder_id());
				order.setUser(user);
				order.setOrderItems(oIlist);
				list.add(order);
			}
		}
		JdbcUtils.releaseConnection(conn);
		return list;
		
	}
}
