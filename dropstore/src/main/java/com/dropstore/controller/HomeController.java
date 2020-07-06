package com.dropstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	@RequestMapping("/home/index")
	public String index() {
	    System.out.println("## chay index" );
		return "home/index";
	}
	@RequestMapping("/home/aboutus")
	public String aboutus() {
	    System.out.println("## chay aboutus" );
		return "home/aboutus";
	}
	@RequestMapping("/home/contactus")
	public String contactus() {
	    System.out.println("## chay contactus" );
		return "home/contactus";
	}	@RequestMapping("/home/feedback")
	public String feedback() {
	    System.out.println("## chay feedback" );
		return "home/feedback";
	}	@RequestMapping("/home/faqs")
	public String faqs() {
	    System.out.println("## chay faqs" );
		return "home/faqs";
	}	
//		@RequestMapping("/home/aboutus")
//	public String aboutus() {
//	    System.out.println("## chay controller" );
//		return "home/aboutus";
//	}
	
	
	
}
