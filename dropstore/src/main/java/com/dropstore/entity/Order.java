package com.dropstore.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity @Table(name="orders")
public class Order {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	//String customerld;
	@Temporal(TemporalType.TIMESTAMP )
	@DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	Date orderDate;
	String address;
	Double amount;
	String description;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	Customer customer;
	@OneToMany(mappedBy = "order")
	List<Orderdetail> orderdetails;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Orderdetail> getOrderdetails() {
		return orderdetails;
	}
	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}
	
	
}
