package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@RequestMapping("/login")
	public String displayLoginPage() {
		return "login";
	}
	
	@PostMapping("/validate")
	public ModelAndView validateUser(HttpSession session,@RequestParam String uname,@RequestParam String pass) {
		MyUser u1=loginService.validate(uname,pass);
		if(u1!=null) {
			session.setAttribute("user",u1);
			return new ModelAndView("redirect:/product/viewproduct");
			//return new ModelAndView("hello","msg","login successful!!");
		}else {
			
			return new ModelAndView("login","msg","please reenter credentials");
			
		}
	}
}
