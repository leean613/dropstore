package com.dropstore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dropstore.entity.Order;
@Transactional
@Repository
public class OrderDAOimpl implements OrderDAO {
	
	@Autowired
	SessionFactory factory;
	@Override
	public Order findByID(Integer id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Order entity = session.find(Order.class, id);
		return entity;
	}

	@Override
	public List<Order> findAll() {
		String hql="FROM Order";
		Session session=factory.getCurrentSession();
		// TODO Auto-generated method stub
		TypedQuery<Order> query= session.createQuery(hql,Order.class);
		List<Order> list=query.getResultList();
		return list;
	}

	@Override
	public Order create(Order entity) {
		
		Session session=factory.getCurrentSession();
		session.save(entity);
		// TODO Auto-generated method stub
		return entity;
	}

	@Override
	public void update(Order entity) {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public Order delete(Integer id) {
		Session session=factory.getCurrentSession();
		Order entity = session.find(Order.class, id);
		session.delete(entity);
		return entity;
		
		// TODO Auto-generated method stub
		
	}
	

}
