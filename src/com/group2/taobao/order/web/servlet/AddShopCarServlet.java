package com.group2.taobao.order.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group2.taobao.commodity.domain.Commodity;
import com.group2.taobao.order.domain.OrderItem;
import com.group2.taobao.order.service.OrderItemService;
import com.group2.taobao.user.domain.User;
import com.group2.taobao.utils.CommonUtils;

/**
 * Servlet implementation class AddShopCarService
 */
@WebServlet("/AddShopCarServlet")
public class AddShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderItemService service = new OrderItemService();

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String commodity_id = request.getParameter("commodity_id");
		String Sprice = request.getParameter("commodity_price");
		double price = Double.valueOf(Sprice);
		User user = (User) request.getSession().getAttribute("user");
		if(commodity_id!=null){
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder_item_id(CommonUtils.uuid());
			orderItem.setOrder_item_count(1);
			orderItem.setOrder_item_subtotal(1*price);
			Commodity commodity = new Commodity();
			commodity.setCommodity_id(commodity_id);
			orderItem.setCommodity(commodity);
			orderItem.setUser(user);
			
			if(service.addShopCar(orderItem)){
				request.getRequestDispatcher("/MyShopCarServlet?user_id="+user.getUser_id()).forward(request, response);
			}else{
				request.setAttribute("shopcarmasage", "ÃÌº” ß∞‹");
				request.getRequestDispatcher("/myshopcar.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("shopcarmasage", "ÃÌº” ß∞‹");
			request.getRequestDispatcher("/myshopcar.jsp").forward(request, response);
		}
	}

}
