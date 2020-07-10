package com.dropstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dropstore.interceptor.AuthorizeInterceptor;
import com.dropstore.interceptor.Shareinterceptor;
@Configuration
public class interceptorConfig implements WebMvcConfigurer{
	@Autowired
	Shareinterceptor share;
	@Autowired
	AuthorizeInterceptor auth;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(share).addPathPatterns("/**");
	

	registry.addInterceptor(auth).
	addPathPatterns("/account/change","/account/logoff","/account/edit","/order/**");
	}
}
