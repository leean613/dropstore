package com.dropstore.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//import com.dropstore.dao.CategoryDAO;
//import com.dropstore.dao.ProductDAO;
//import com.dropstore.entity.Category;
//import com.dropstore.entity.Product;
import com.dropstore.entity.Customer;

@Component
public class AuthorizeInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		Customer user=(Customer) session.getAttribute("user");
		if(user==null){
			session.setAttribute("back_url",request.getRequestURI());
			response.sendRedirect("/account/login");
//			System.out.println(session.getAttribute("back_url"));
			return false;
		}
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}
