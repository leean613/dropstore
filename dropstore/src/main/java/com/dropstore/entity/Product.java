package com.dropstore.entity;



import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
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

@Entity @Table(name="products")
public class Product {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	Double unitprice;
	String image;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	Date productDate;
	Boolean available;
	//Integer categoryId;
	Integer quantity;
	String description;
	Double discount;
	Integer viewCount;
	Boolean special;
	@ManyToOne
	@JoinColumn(name="categoryId")
	Category category;
	
	@OneToMany(mappedBy = "product")
	List<Orderdetail> orderdetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public Boolean getSpecial() {
		return special;
	}

	public void setSpecial(Boolean special) {
		this.special = special;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Orderdetail> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}
	
	
}
