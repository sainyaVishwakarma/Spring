package com.demo.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;
	
	@Override
	public void addNewProduct() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter pid: ");
		int pid=sc.nextInt();
		System.out.println("Enter pname: ");
		String pname=sc.next();
		System.out.println("Enter qty: ");
		int qty=sc.nextInt();
		System.out.println("Enter price: ");
		float price=sc.nextFloat();
		Product p=new Product(pid,pname,qty,price);
		productDao.save(p);
	}

	@Override
	public List<Product> displayAll() {
		// TODO Auto-generated method stub
		return productDao.getAll();
	}

	@Override
	public Product displayById(int pid) {
		// TODO Auto-generated method stub
		return productDao.getById(pid);
	}

	@Override
	public boolean deleteById(int pid) {
		// TODO Auto-generated method stub
		return productDao.deleteById(pid);
	}

	@Override
	public List<Product> sortByName() {
		// TODO Auto-generated method stub
		return productDao.sortByName();
	}

	@Override
	public boolean updateById(int pid, String pname) {
		// TODO Auto-generated method stub
		return productDao.modifyById(pid,pname);
	}

}
