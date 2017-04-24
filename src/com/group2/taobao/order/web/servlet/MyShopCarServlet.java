package com.group2.taobao.order.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group2.taobao.order.domain.OrderItem;
import com.group2.taobao.order.service.OrderItemService;
import com.group2.taobao.user.domain.User;

@WebServlet("/MyShopCarServlet")
public class MyShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		OrderItemService service = new OrderItemService();
		
		User user= (User) request.getSession().getAttribute("user");
		List<OrderItem> list = service.getMyOrderItem(user.getUser_id());
		if(list!=null){
			request.getSession().setAttribute("myItems",list);
			response.sendRedirect(request.getServletContext().getContextPath()+"/myshopcar.jsp");
		}else{
			request.setAttribute("shopcar_message", "∂¡»° ß∞‹");
		}
	}
}
