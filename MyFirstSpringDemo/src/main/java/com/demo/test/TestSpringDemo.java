package com.demo.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Address;
import com.demo.beans.Helloworld;
import com.demo.beans.MyUser;
import com.demo.beans.Team;

public class TestSpringDemo {

	public static void main(String[] args) {
//		HelloWorld hw = new HelloWorld();
//		hw.SayHello();
//		
//		XmlBeanFactory bf=new XmlBeanFactory(new ClassPathResource("Springconfig.xml"));
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Springconfig.xml");
		System.out.println("before getbean");
//		Helloworld hbean=(Helloworld)bf.getBean("hw");
		Helloworld hbean=(Helloworld)ctx.getBean("hw");
		 System.out.println("after getbean");
		 hbean.sayHello();
		 
		 MyUser u=(MyUser) ctx.getBean("u1");
		 System.out.println(u);
		 
		 Address addr=(Address) ctx.getBean("add");
		 System.out.println(addr);
		 
		 
		 ((ClassPathXmlApplicationContext) ctx).close();

	}
}
