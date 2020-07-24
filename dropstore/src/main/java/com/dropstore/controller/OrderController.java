package com.dropstore.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.util.pattern.PathPattern;

import com.dropstore.dao.OrderDAO;
import com.dropstore.dao.OrderdetailDAO;
import com.dropstore.entity.Customer;
import com.dropstore.entity.Order;
import com.dropstore.entity.Orderdetail;
import com.dropstore.entity.Product;
import com.dropstore.service.CartsService;

@Controller
public class OrderController {
	@Autowired
	HttpSession session;
	@Autowired
	CartsService cart;
	@Autowired
	OrderDAO odao;
	@Autowired
	OrderdetailDAO ddao;
	@GetMapping("/order/checkout")
	public String showform(@ModelAttribute("order") Order order) {
		Customer user=(Customer) session.getAttribute("user");
		order.setOrderDate(new Date());
		System.out.println(order.getOrderDate());
		order.setCustomer(user);
		order.setAmount(cart.getAmount());
		return "order/checkout";
	}
	@PostMapping("/order/checkout")
	public String purchase(Model model,@ModelAttribute("order") Order order) {
		Collection<Product> list= cart.getItems();
		List<Orderdetail> details=new ArrayList<Orderdetail>();
		for(Product product:list)
		{
			Orderdetail detail =new Orderdetail();
			detail.setOrder(order);
			detail.setProduct(product);
			detail.setUnitPrice(product.getUnitprice());
			System.out.println(product.getName()+" "+ product.getQuantity());
			detail.setQuantity(product.getQuantity());
			detail.setDiscount(product.getDiscount());
			details.add(detail);
		}
		odao.create(order,details);
		System.out.println("thong tin don hang: "+order.getCustomer()+" "+order.getId());
		
		for(Orderdetail d:details)
		{
			//Orderdetail detail =new Orderdetail();
		System.out.println("orderid= "+d.getOrder());	
		System.out.println("prodid= "+d.getProduct());
		System.out.println("price= "+	d.getUnitPrice());
			//System.out.println(d.getName()+" "+ product.getQuantity());
		System.out.println("quantity= "+	d.getQuantity());
		System.out.println("discount= "+	d.getDiscount());
		}
		cart.clear();
		return "redirect:/order/list";
	}
	@GetMapping("/order/list")
	public String list(Model model) {
		Customer user= (Customer) session.getAttribute("user");
		List<Order> orders = odao.findByUser(user);
		model.addAttribute("orders",orders);
		return "order/list";
	}
	@GetMapping("/order/detail/{id}")
	public String detail(Model model,@PathVariable("id") Integer id ) {
		Order order = odao.findByID(id);
		List<Orderdetail> details = ddao.findByOrder(order);
		model.addAttribute("order",order);
		model.addAttribute("details",details);
		return "order/detail";
	}
	@GetMapping("/order/items")
	public String items(Model model) {
		Customer user=(Customer) session.getAttribute("user");
		List<Product> list = odao.findItemsbyUser(user);
		model.addAttribute("list",list);
		return "product/list";
	}
	
	
}
