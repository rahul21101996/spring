package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.bean.Product;
@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Product> getallproduct() {
		String sql="select * from product";
		List<Product> plist=(List<Product>) jdbcTemplate.query(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				
				return p;
			}
			});
		return plist;
	}
	@Override
	public Product editproduct(int pid) {
		String sql="select * from product where pid=?";
		Product p=(Product)jdbcTemplate.queryForObject(sql, new Object[] {pid}, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				return p;
			}
		});
		return p;
	}
	@Override
	public int updateProduct(Product p) {
		String sql="update product set pname=?,price=? where pid=?";
		
		return jdbcTemplate.update(sql, new Object[] {p.getPname(),p.getPrice(),p.getPid()});
	}
	@Override
	public int deleteprod(int pid) {
		String sql="delete from product where pid=?";
		return jdbcTemplate.update(sql, new Object[] {pid}); 
		
	}
	@Override
	public int addproduct(int pid,String pname,double price) {
		String sql="insert into product(pid,pname,price) values(?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {pid,pname,price});
		
	}

}
