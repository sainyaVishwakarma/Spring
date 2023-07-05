package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void addNewProduct();

	List<Product> displayAll();

	Product displayById(int pid);

	boolean deleteById(int pid);

	List<Product> sortByName();

	boolean updateById(int pid, String pname);

}
