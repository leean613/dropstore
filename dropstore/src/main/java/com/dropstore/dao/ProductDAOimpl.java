package com.dropstore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dropstore.entity.Product;
@Transactional
@Repository
public class ProductDAOimpl implements ProductDAO {
	
	@Autowired
	SessionFactory factory;
	@Override
	public Product findByID(Integer id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Product entity = session.find(Product.class, id);
		return entity;
	}

	@Override
	public List<Product> findAll() {
		String hql="FROM Product";
		Session session=factory.getCurrentSession();
		// TODO Auto-generated method stub
		TypedQuery<Product> query= session.createQuery(hql,Product.class);
		List<Product> list=query.getResultList();
		return list;
	}

	@Override
	public Product create(Product entity) {
		
		Session session=factory.getCurrentSession();
		session.save(entity);
		// TODO Auto-generated method stub
		return entity;
	}

	@Override
	public void update(Product entity) {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public Product delete(Integer id) {
		Session session=factory.getCurrentSession();
		Product entity = session.find(Product.class, id);
		session.delete(entity);
		return entity;
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> findByCategoryId(Integer categoryId) {
		String hql="FROM Product p WHERE p.category.id=:cid";
		System.out.println(hql);
		Session session=factory.getCurrentSession();
		// TODO Auto-generated method stub
		TypedQuery<Product> query= session.createQuery(hql,Product.class);
		query.setParameter("cid", categoryId);
		List<Product> list=query.getResultList();
		return list;
		
	}

	@Override
	public List<Product> findByKeywords(String keywords) {
		String hql="FROM Product p WHERE p.name LIKE:kw OR p.category.name LIKE:kw OR p.category.nameVN LIKE:kw" ;//ORDER BY p.unitprice DESC để xắp sếp tăng giảm
		System.out.println(hql);
		Session session=factory.getCurrentSession();
		// TODO Auto-generated method stub
		TypedQuery<Product> query= session.createQuery(hql,Product.class);
		query.setParameter("kw", "%"+keywords+"%");
		List<Product> list=query.getResultList();
		return list;
		
	}

	@Override
	public List<Product> findByIds(String ids) {
		String hql="FROM Product p WHERE p.id IN ("+ids+")";//ORDER BY p.unitprice DESC để xắp sếp tăng giảm
		System.out.println(hql);
		Session session=factory.getCurrentSession();
		// TODO Auto-generated method stub
		TypedQuery<Product> query= session.createQuery(hql,Product.class);
		List<Product> list=query.getResultList();
		return list;
	}

	@Override
	public List<Product> findBySpecial(Integer id) {
		Session session=factory.getCurrentSession();
		String hql="FROM Product";
		TypedQuery<Product> query= session.createQuery(hql,Product.class);
		
		switch (id) {
		case 0:// mới
			 hql="FROM Product p ORDER BY p.productDate DESC";//ORDER BY p.unitprice DESC để xắp sếp tăng giảm
			
			
			break;
		case 1:// bán chạy
			
			break;
		case 2:// xem nhiều
			 hql="FROM Product p ORDER BY p.viewCount DESC";//ORDER BY p.unitprice DESC để xắp sếp tăng giảm
			
			
			break;
		case 3:// giảm giá
			 hql="FROM Product p ORDER BY p.discount DESC";//ORDER BY p.unitprice DESC để xắp sếp tăng giảm
			
			
			break;
		
		}
		query= session.createQuery(hql,Product.class);
		query.setMaxResults(3);
		
		System.out.println(hql);
		// TODO Auto-generated method stub
		
		
		List<Product> list=query.getResultList();
		return list;
	}
	

}
