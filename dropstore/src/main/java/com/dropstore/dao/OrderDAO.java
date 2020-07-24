package com.dropstore.dao;

import java.util.List;

import com.dropstore.entity.Customer;
import com.dropstore.entity.Order;
import com.dropstore.entity.Orderdetail;
import com.dropstore.entity.Product;

public interface OrderDAO {
 Order	findByID(Integer id);
 List<Order> findAll();
 Order create(Order entity);
 void update(Order entity);
 Order delete(Integer id);
void create(Order order, List<Orderdetail> details);
List<Order> findByUser(Customer user);
List<Product> findItemsbyUser(Customer user);
}
