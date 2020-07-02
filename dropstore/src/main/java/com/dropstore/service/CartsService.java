package com.dropstore.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.dropstore.dao.ProductDAO;
import com.dropstore.entity.Product;

@SessionScope//Name: scopedTarget.cartService
@Service
public class CartsService {
@Autowired
ProductDAO pdao;
	
	Map<Integer, Product> map=new HashMap<>();
	public void add(Integer id) {
		 Product p=map.get(id);
		if(p==null) {
			p=pdao.findByID(id);
			p.setQuantity(1);
			map.put(id, p);
		}
		else {
			p.setQuantity(p.getQuantity()+1);
		}
	}
 	public void remove(Integer id) {
		map.remove(id);
	}
	public void update(Integer id,int qty) {
		Product p=map.get(id);
		p.setQuantity(qty);;
	}
	public void clear() {
		map.clear();
	}
	public int getCount() {
		int count=0;
		Collection<Product> ps=this.getItems();
		for(Product p:ps){
			count+=p.getQuantity();
		}
		return count;
	}
	public double getAmount() {
		Collection<Product> ps=this.getItems();
		double amount=0;
		for(Product p:ps) {
			amount+=(p.getUnitprice()*p.getQuantity())*(1-p.getDiscount());
		}
		return amount;
	}
	public Collection<Product> getItems() {
		return map.values();
	}
	
	
	
	
}
