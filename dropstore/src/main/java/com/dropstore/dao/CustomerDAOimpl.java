package com.dropstore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dropstore.entity.Customer;
@Transactional
@Repository
public class CustomerDAOimpl implements CustomerDAO {
	
	@Autowired
	SessionFactory factory;
	@Override
	public Customer findByID(String id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Customer entity = session.find(Customer.class, id);
		return entity;
	}

	@Override
	public List<Customer> findAll() {
		String hql="FROM Customer";
		Session session=factory.getCurrentSession();
		// TODO Auto-generated method stub
		TypedQuery<Customer> query= session.createQuery(hql,Customer.class);
		List<Customer> list=query.getResultList();
		return list;
	}

	@Override
	public Customer create(Customer entity) {
		
		Session session=factory.getCurrentSession();
		session.save(entity);
		// TODO Auto-generated method stub
		return entity;
	}

	@Override
	public void update(Customer entity) {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public Customer delete(String id) {
		Session session=factory.getCurrentSession();
		Customer entity = session.find(Customer.class, id);
		session.delete(entity);
		return entity;
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> findByKeywords(String keywords) {
		String hql="FROM Customer c WHERE c.id LIKE:kw OR c.fullname LIKE:kw OR c.email LIKE:kw" ;//ORDER BY p.unitprice DESC để xắp sếp tăng giảm
		System.out.println(hql);
		Session session=factory.getCurrentSession();
		// TODO Auto-generated method stub
		TypedQuery<Customer> query= session.createQuery(hql,Customer.class);
		query.setParameter("kw", "%"+keywords+"%");
		List<Customer> list=query.getResultList();
	
		return list;
		
		
	}
	

}
