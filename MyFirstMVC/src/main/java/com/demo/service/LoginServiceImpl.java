package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.MyUser;
import com.demo.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDao loginDao;
	@Override
	public MyUser validate(String uname, String pass) {
		// TODO Auto-generated method stub
		return loginDao.authenticateUser(uname,pass);
	}

}
