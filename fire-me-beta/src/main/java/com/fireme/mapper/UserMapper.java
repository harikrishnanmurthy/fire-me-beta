package com.fireme.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ambank.gst.web.model.FITRModel;
import com.fireme.model.User;

public class UserMapper implements RowMapper<User> {
	
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user=new User();		
		        
		user.setUserId(rs.getString("userId"));
		user.setUserName(rs.getString("userName"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setType(rs.getString("type"));
		user.setPassword(rs.getString("password"));
		
		return user;
	}
}
