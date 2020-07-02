package com.dropstore.dao;

import java.util.List;

import com.dropstore.entity.Order;

public interface OrderDAO {
 Order	findByID(Integer id);
 List<Order> findAll();
 Order create(Order entity);
 void update(Order entity);
 Order delete(Integer id);
}
