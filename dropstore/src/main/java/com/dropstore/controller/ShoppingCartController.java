package com.dropstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dropstore.service.CartsService;
@Controller
public class ShoppingCartController {
	@Autowired
	CartsService cart;
	
	@ResponseBody
	@RequestMapping("/cart/add/{id}")
	public Object add(@PathVariable("id") Integer id ) {
		cart.add(id);
		Object[] info= {cart.getCount(),cart.getAmount()};
		System.out.println("test chuoi "+info);
		return info;
	}

}

