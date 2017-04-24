package com.group2.taobao.order.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group2.taobao.order.service.OrderService;
import com.group2.taobao.user.domain.User;

/**
 * Servlet implementation class AddOrderSerlet
 */
@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService service = new OrderService();
		String[] order_item_id = request.getParameterValues("order_item_id");
		User user = (User) request.getSession().getAttribute("user");
		if(order_item_id!=null){
			if(service.createOrder(order_item_id,user)){
				System.out.println("³É¹¦");
			}else{
				System.out.println("Ê§°Ü1");
			}
		}else{
			System.out.println("Ê§°Ü2");
		}
	}
}
