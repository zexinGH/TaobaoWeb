package com.group2.taobao.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.group2.taobao.user.domain.User;


@WebFilter(filterName="loginfilter",
		urlPatterns = { "/AddShopCarServlet" ,"/UpdateUserServlet","/user.jsp","/myshopcar.jsp"} 
		)
public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest reqs = (HttpServletRequest) request;
		HttpSession session = reqs.getSession();
		User user = (User) session.getAttribute("user");
		
		if(user==null){
			request.setAttribute("message", "ÇëÏÈ½øÐÐµÇÂ¼£¡");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
