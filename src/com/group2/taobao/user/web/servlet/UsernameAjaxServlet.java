package com.group2.taobao.user.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group2.taobao.user.service.AjaxService;

@WebServlet("/UsernameAjaxServlet")
public class UsernameAjaxServlet extends HttpServlet {
	AjaxService service = new AjaxService();
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String user_name = request.getParameter("user_name");
		
		if(service.verifyUsername(user_name)){
			response.getWriter().print("<a1 style='color:green'>恭喜！用户名可用！</a1>");
		}else{
			response.getWriter().print("<a1>该用户已被注册！</a1>");
		}
		
	}
}
