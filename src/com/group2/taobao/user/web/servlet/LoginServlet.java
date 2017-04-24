package com.group2.taobao.user.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group2.taobao.user.domain.User;
import com.group2.taobao.user.service.UserService;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userservice = new UserService();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String user_name = request.getParameter("user_name");
		String user_password = request.getParameter("user_password");

		if(user_name!=null && user_password!=null && !user_name.trim().isEmpty() && !user_password.trim().isEmpty()){
			User user = userservice.login(user_name, user_password);

			if(user == null){
				request.setAttribute("message", "系统提示:您登录失败，请重新登录!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}else{
				request.getSession().setAttribute("user", user);
				response.sendRedirect(request.getServletContext().getContextPath()+"/index.jsp");
			}
		}else{
			request.setAttribute("message", "系统提示:您登录失败，请重新登录!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
