package com.dropstore.dao;

import java.util.List;

import com.dropstore.entity.Category;

public interface CategoryDAO {
 Category	findByID(Integer id);
 List<Category> findAll();
 Category create(Category entity);
 void update(Category entity);
 Category delete(Integer id);
}
