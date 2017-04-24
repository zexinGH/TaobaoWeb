package com.group2.taobao.commodity.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group2.taobao.commodity.domain.Commodity;
import com.group2.taobao.commodity.service.CommodityService;


@WebServlet("/CommodityServlet")
public class CommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		CommodityService service = new CommodityService();
		
		String commodity_id = request.getParameter("commodity_id");
		Commodity commodity = service.findCommodity(commodity_id);
		
		if(commodity!=null){
			request.setAttribute("commodity", commodity);
			request.getRequestDispatcher("/commodity.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "没找到这个商品");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
