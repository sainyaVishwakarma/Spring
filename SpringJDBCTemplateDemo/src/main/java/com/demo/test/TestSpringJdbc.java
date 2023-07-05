package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Product;
import com.demo.service.ProductService;

public class TestSpringJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		ProductService ps=(ProductService) ctx.getBean("productServiceImpl");
		Scanner sc=new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("1. add new product\n 2. delete by id\n 3. display all\n 4. display by id\n 5. sort by name\n 6. update by id\n 7. exit\n Enter choice: ");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				ps.addNewProduct();
				break;
			case 2:
				System.out.println("Enter pid");
				int pid=sc.nextInt();
				boolean status=ps.deleteById(pid);
				if(status) {
					System.out.println("deleted successfully!");
				}else {
					System.out.println("not found");
				}
				break;
			case 3:
				List<Product> plist=ps.displayAll();
				plist.forEach(System.out::println);
				break;
			case 4:
				System.out.println("Enter pid");
				 pid=sc.nextInt();
				Product p=ps.displayById(pid);
				if(p!=null) {
					System.out.println(p);
				}else {
					System.out.println("not found");
				}
				break;
			case 5:
			    plist=ps.sortByName();
				plist.forEach(System.out::println);
				break;
			case 6:
				System.out.println("Enter pid");
				 pid=sc.nextInt();
				 System.out.println("Enter pname");
				 String pname=sc.next();
				  status=ps.updateById(pid,pname);
					if(status) {
						System.out.println("modified successfully!");
					}else {
						System.out.println("not found");
					}
				break;
			case 7:
				System.out.println("Thank you for visiting!");
				break;
			default:
				System.out.println("wrong choice");
			}
		}while(choice!=7);
	}

}
