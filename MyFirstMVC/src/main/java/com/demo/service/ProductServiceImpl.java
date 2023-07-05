package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> showAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProduct();
	}

	@Override
	public int addNewProduct(Product p) {
		// TODO Auto-generated method stub
		return productDao.save(p);
	}

	@Override
	public int deleteById(int pid) {
		// TODO Auto-generated method stub
		return productDao.removeById(pid);
	}

	@Override
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		return productDao.findById(pid);
	}

	@Override
	public void modifyProduct(Product p) {
		// TODO Auto-generated method stub
		productDao.updateProduct(p);
	}
	
}
