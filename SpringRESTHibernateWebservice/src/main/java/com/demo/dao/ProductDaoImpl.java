package com.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		Session sess=sessionFactory.openSession();
		Transaction tr= sess.beginTransaction();
		Query query=sess.createQuery("from Product");
		List<Product> plist=query.list();
		
		tr.commit();
		sess.close();
		return plist;
	
	}
	@Override
	public Product findById(int pid) {
		// TODO Auto-generated method stub
		try {
		Session sess=sessionFactory.openSession();
		Transaction tr= sess.beginTransaction();
		Product p=sess.get(Product.class,pid);
			tr.commit();
			sess.close();
			return p;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	@Override
	public int addNewProduct(Product p) {
		// TODO Auto-generated method stub
		try {
			Session sess=sessionFactory.openSession();
			Transaction tr=sess.beginTransaction();
			sess.save(p);
			tr.commit();
			sess.close();
		    return 1;
		}catch(DataAccessException e) {
			return 0;
		}
		
	}
	@Override
	public int updateById(Product p) {
		// TODO Auto-generated method stub
		
			Session sess=sessionFactory.openSession();
			Transaction tr=sess.beginTransaction();
			Product p1=sess.get(Product.class,p.getPid());
			if(p1!=null) {
			p1.setPname(p.getPname());
			p1.setQty(p.getQty());
			p1.setPrice(p.getPrice());
			tr.commit();
			sess.close();
		    return 1;
			}
		tr.commit();
		sess.close();
		return 0;
	}
	@Override
	public int deleteById(int pid) {
		// TODO Auto-generated method stub
		
			Session sess=sessionFactory.openSession();
			Transaction tr= sess.beginTransaction();
			Product p=sess.get(Product.class,pid);
			if(p!=null) {
				sess.delete(p);
				tr.commit();
				sess.close();
				return 1;
			}
			tr.commit();
			sess.close();
			return 0;	
	}
	

}

