package com.dropstore.dao;

import java.util.List;

import com.dropstore.entity.Customer;
import com.dropstore.entity.Order;
import com.dropstore.entity.Orderdetail;
import com.dropstore.entity.Product;

public interface OrderdetailDAO {
 Orderdetail	findByID(Integer id);
 List<Orderdetail> findAll();
 Orderdetail create(Orderdetail entity);
 void update(Orderdetail entity);
 Orderdetail delete(Integer id);
List<Orderdetail> findByOrder(Order order);
}
