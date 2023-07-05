package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Product;
import com.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping("/viewproduct")
	public ModelAndView showAllProduct() {
		System.out.println("in show all product method");
		List<Product> plist=productService.showAllProducts();
		return new ModelAndView("displayproduct","plist",plist);
	}
	@GetMapping("/addnewproduct")
	public String addNewProduct() {
		return "addproduct";
	}
	@PostMapping("/addproduct")
	public ModelAndView addProduct(@RequestParam int pid,@RequestParam String pname,@RequestParam int qty,@RequestParam float price) {
		Product p=new Product(pid,pname,qty,price);
		int n=productService.addNewProduct(p);
		return new ModelAndView("redirect:/product/viewproduct");
	}
	@GetMapping("/delete/{pid}")
	public ModelAndView deleteProductById(@PathVariable int pid) {
		int n=productService.deleteById(pid);
		return new ModelAndView("redirect:/product/viewproduct");
	}
	
	@GetMapping("/edit/{pid}")
	public ModelAndView editProductById(@PathVariable int pid) {
		Product p=productService.getById(pid);
		return new ModelAndView("editproduct","prod",p);
	}
	
	@PostMapping("/updateproduct")
	public ModelAndView updateProduct(@RequestParam int pid,@RequestParam String pname,@RequestParam int qty,@RequestParam float price) {
		Product p=new Product(pid,pname,qty,price);
		productService.modifyProduct(p);
		return new ModelAndView("redirect:/product/viewproduct");
	}
}
