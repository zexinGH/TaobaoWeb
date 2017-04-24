package com.group2.taobao.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.group2.taobao.order.domain.OrderItem;

/**
 * Servlet Filter implementation class ShopCarFilter
 */
@WebFilter(filterName="shopcarfilter",
		urlPatterns = { "/myshopcar.jsp"})
public class ShopCarFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest reqs = (HttpServletRequest) request;
		HttpSession session = reqs.getSession();
		List<OrderItem> list = (List<OrderItem>) session.getAttribute("myItems");
		if(list==null){
			request.getRequestDispatcher("/MyShopCarServlet").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
