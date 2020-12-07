package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.bean.User;

@Repository
public class LoginDaoImpl implements LoginDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public User validateUser(String uname, String pass) {
		String sql="select * from user where uname=? and pass=?";
		
		User u=(User)jdbcTemplate.queryForObject(sql, new Object[] {uname,pass}, new RowMapper<User>() {

			
			@Override
			public User mapRow(ResultSet rs, int num) throws SQLException {
				
				User u=new User(rs.getString(1),rs.getString(2));
				return u;
				/*if((rs.getString(1).equals(uname)) && (rs.getString(2).equals(pass)))
				
				{
					return true;
				}*/	
			}
			
		}) ;
		
		return u;
		
		}
	}


