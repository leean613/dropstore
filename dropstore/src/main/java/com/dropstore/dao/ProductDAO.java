package com.dropstore.dao;

import java.util.List;

import com.dropstore.entity.Product;

public interface ProductDAO {
 Product	findByID(Integer id);
 List<Product> findAll();
 Product create(Product entity);
 void update(Product entity);
 Product delete(Integer id);
List<Product> findByCategoryId(Integer categoryId);
List<Product> findByKeywords(String keywords);
List<Product> findByIds(String ids);
List<Product> findBySpecial(Integer id);
}
