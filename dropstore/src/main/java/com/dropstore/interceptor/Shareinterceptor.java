package com.dropstore.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dropstore.dao.CategoryDAO;
//import com.dropstore.dao.ProductDAO;
import com.dropstore.entity.Category;
//import com.dropstore.entity.Product;

@Component
public class Shareinterceptor extends HandlerInterceptorAdapter {
	@Autowired
	CategoryDAO dao;
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("chay interceptor");
	List<Category> list =dao.findAll();
	request.setAttribute("cates",list);//modelAndView.addObject("cates",list)
	
	
	}
}
