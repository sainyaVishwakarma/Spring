package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void save(Product p) {
		// TODO Auto-generated method stub
		int n=jdbcTemplate.update("insert into prod values(?,?,?,?)",new Object[] {p.getPid(),p.getPname(),p.getQty(),p.getPrice()});
	}
	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		List<Product> plist=jdbcTemplate.query("select * from prod", new RowMapper(){
			public Object mapRow(ResultSet rs,int rows) throws SQLException {
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setQty(rs.getInt(3));
				p.setPrice(rs.getFloat(4));
				return p;
				
		}
			
		});
		return plist;
	}
	@Override
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		Product p=jdbcTemplate.queryForObject("select * from prod where pid=?", new Object[] {pid},BeanPropertyRowMapper.newInstance(Product.class));
		return p;
	}
	@Override
	public boolean deleteById(int pid) {
		// TODO Auto-generated method stub
		int n=jdbcTemplate.update("delete from prod where pid=?",new Object[] {pid});
		return n>0;
	}
	@Override
	public List<Product> sortByName() {
		// TODO Auto-generated method stub
		List<Product> plist=jdbcTemplate.query("select * from prod order by pname",(rs,n)->{
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setQty(rs.getInt(3));
				p.setPrice(rs.getFloat(4));
				return p;
		});
		return plist;
		
	}
	@Override
	public boolean modifyById(int pid, String pname) {
		// TODO Auto-generated method stub
		int n=jdbcTemplate.update("update prod set pname=? where pid=?",new Object[] {pname,pid});
		return n>0;
	}

}
