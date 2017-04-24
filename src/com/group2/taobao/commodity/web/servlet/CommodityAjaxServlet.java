package com.group2.taobao.commodity.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group2.taobao.commodity.service.CommodityService;

/**
 * Servlet implementation class CommodityAjaxServlet
 */
@WebServlet("/CommodityAjaxServlet")
public class CommodityAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommodityService service = new CommodityService();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String keyword = request.getParameter("keyword");
		String json = service.search(keyword);
		response.getWriter().println(json);
	}
}
