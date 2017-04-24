package com.group2.taobao.user.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group2.taobao.user.domain.User;
import com.group2.taobao.user.service.UserService;
import com.group2.taobao.utils.CommonUtils;


/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		UserService service = new UserService();
		Map<String,String[]> map = request.getParameterMap();
		User user = CommonUtils.toBean(map, User.class);
		System.out.println(user);
		if(service.updateUser(user)){
			request.getSession().removeAttribute("user");
			request.getSession().setAttribute("message", "修改成功！请重新登录！");
			response.sendRedirect(request.getServletContext().getContextPath()+"/login.jsp");
		}else{
			request.getSession().removeAttribute("user");
			request.setAttribute("修改失败！请重新登", "message");
			response.sendRedirect(request.getServletContext().getContextPath()+"/login.jsp");	
		}
	}
}
