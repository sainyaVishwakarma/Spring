package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> getAllProduct();

	int save(Product p);

	int removeById(int pid);

	Product findById(int pid);

	int updateProduct(Product p);

}
