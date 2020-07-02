package com.dropstore.dao;

import java.util.List;

import com.dropstore.entity.Customer;

public interface CustomerDAO {
 Customer	findByID(String id);
 List<Customer> findAll();
 Customer create(Customer entity);
 void update(Customer entity);
 Customer delete(Integer id);
}
