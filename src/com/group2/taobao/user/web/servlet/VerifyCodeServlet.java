package com.group2.taobao.user.web.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group2.taobao.utils.VerifyCode;

@WebServlet("/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage();
		request.getSession().setAttribute("vcode",vc.getText());
		VerifyCode.output(image, response.getOutputStream());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String verify_code = request.getParameter("verify_code");
		String vcode = (String) request.getSession().getAttribute("vcode");
		if(verify_code!=null&&!verify_code.trim().isEmpty()){
		if(vcode.equalsIgnoreCase(verify_code)){
			response.getWriter().print("<a1 style='color:green'>��֤����ȷ!</a1>");
			}else{
				response.getWriter().print("<a1>��֤�����!</a1>");
			}
		}else{
			response.getWriter().print("<a1>������������֤��!</a1>");
		}
	}
}
