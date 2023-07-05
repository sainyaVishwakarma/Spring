package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void save(Product p);

	List<Product> getAll();

	Product getById(int pid);

	boolean deleteById(int pid);

	List<Product> sortByName();

	boolean modifyById(int pid, String pname);

}
