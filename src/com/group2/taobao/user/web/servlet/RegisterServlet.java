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


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserService();

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String verify_code = request.getParameter("verify_code");
		String vcode = (String) request.getSession().getAttribute("vcode");
		if(vcode.equalsIgnoreCase(verify_code)){

			Map<String, String[]> map = request.getParameterMap();

			User user = CommonUtils.toBean(map, User.class);
			user.setUser_id(CommonUtils.uuid());
			user.setUser_level(1);
			if(user.getUser_gender().equals("Ů")){
				user.setUser_gender("female");
			}else{
				user.setUser_gender("male");
			}
				
			if(service.register(user)){
				request.getSession().setAttribute("message", "��ϲע��ɹ������¼��");
				response.sendRedirect(request.getServletContext().getContextPath()+"/login.jsp");
			}else{
				request.setAttribute("message", "ע��ʧ�ܣ�������ע�ᣡ");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}	
		}else{
			request.setAttribute("message", "��֤�����ע��ʧ�ܣ�������ע�ᣡ");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
	}
}
