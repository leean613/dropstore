package com.dropstore.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminHomeController {
	@RequestMapping("admin/home/index")
	public String index() {
	    System.out.println("## chay index" );
		return "admin/home/index";
	}
}
