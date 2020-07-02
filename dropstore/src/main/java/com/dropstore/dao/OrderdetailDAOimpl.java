package com.dropstore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dropstore.entity.Orderdetail;
@Transactional
@Repository
public class OrderdetailDAOimpl implements OrderdetailDAO {
	
	@Autowired
	SessionFactory factory;
	@Override
	public Orderdetail findByID(Integer id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Orderdetail entity = session.find(Orderdetail.class, id);
		return entity;
	}

	@Override
	public List<Orderdetail> findAll() {
		String hql="FROM Orderdetail";
		Session session=factory.getCurrentSession();
		// TODO Auto-generated method stub
		TypedQuery<Orderdetail> query= session.createQuery(hql,Orderdetail.class);
		List<Orderdetail> list=query.getResultList();
		return list;
	}

	@Override
	public Orderdetail create(Orderdetail entity) {
		
		Session session=factory.getCurrentSession();
		session.save(entity);
		// TODO Auto-generated method stub
		return entity;
	}

	@Override
	public void update(Orderdetail entity) {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public Orderdetail delete(Integer id) {
		Session session=factory.getCurrentSession();
		Orderdetail entity = session.find(Orderdetail.class, id);
		session.delete(entity);
		return entity;
		
		// TODO Auto-generated method stub
		
	}
	

}
