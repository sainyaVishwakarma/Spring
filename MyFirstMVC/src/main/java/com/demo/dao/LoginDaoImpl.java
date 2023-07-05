package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.demo.beans.MyUser;

@Repository
public class LoginDaoImpl implements LoginDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public MyUser authenticateUser(String uname, String pass) {
		// TODO Auto-generated method stub
		try {
		MyUser u1=jdbcTemplate.queryForObject("select * from user where uname=? and password=?", new Object[] {uname,pass}, BeanPropertyRowMapper.newInstance(MyUser.class));
		return u1;
		
	}catch(EmptyResultDataAccessException e) {
		return null;
	}
	}

}
