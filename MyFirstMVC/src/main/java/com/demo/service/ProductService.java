package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> showAllProducts();

	int addNewProduct(Product p);

	int deleteById(int pid);

	Product getById(int pid);

	void modifyProduct(Product p);

}
