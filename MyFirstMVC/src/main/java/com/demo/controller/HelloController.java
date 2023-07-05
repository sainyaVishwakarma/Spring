package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HelloController {
	@RequestMapping("/")
	public String displayHomePage() {
		System.out.println("in home page");
		return "index";
	}
	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		String message="this is message from say hello";
		return new ModelAndView ("hello","msg",message);
	}
	
}
