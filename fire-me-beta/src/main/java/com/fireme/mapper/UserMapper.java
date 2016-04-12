package com.fireme.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fireme.model.User;

public class UserMapper implements RowMapper<User> {
	
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user=new User();		
		user.setUserId(rs.getString("USER_ID"));
		user.setUserName(rs.getString("USERNAME"));
		user.setFirstName(rs.getString("FIRST_NAME"));
		user.setLastName(rs.getString("LAST_NAME"));
		user.setType(rs.getString("TYPE"));
		user.setEmail(rs.getString("EMAIL_ID"));
		return user;
	}
}
