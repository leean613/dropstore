package com.dropstore.dao;

import java.util.List;

import com.dropstore.entity.Orderdetail;

public interface OrderdetailDAO {
 Orderdetail	findByID(Integer id);
 List<Orderdetail> findAll();
 Orderdetail create(Orderdetail entity);
 void update(Orderdetail entity);
 Orderdetail delete(Integer id);
}
