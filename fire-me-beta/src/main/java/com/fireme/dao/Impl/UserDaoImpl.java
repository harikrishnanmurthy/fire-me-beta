package com.fireme.dao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.fireme.dao.UserDao;
import com.fireme.mapper.UserMapper;
import com.fireme.model.User;

@Component("usersDao")
public class UserDaoImpl implements UserDao{
private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public String createUser(User user) {
		String sql = "INSERT INTO USER(USER_ID,USER_NAME,PASSWORD,FIRST_NAME,LAST_NAME,TYPE,EMAIL_ID,PHONE)VALUES(?,?,?,?,?,?,?,?);";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sql, new Object[] {user.getUserId(),user.getUserName(),user.getPassword(),user.getFirstName(),user.getLastName(),user.getType(),user.getEmail(),user.getPhoneNo()});
	 	try {
			dataSource.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Override
	public List<User> listUsers() {
		System.out.println("inside dao");
		String sql = "Select * from User";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		List<User> userList = jdbcTemplate.query(sql,new UserMapper());
//		List<User> userList =  new ArrayList<User>();
		return userList;
	}

	@Override
	public int deleteUser(String userId) {
		String sqlQuery="DELETE user where userId =?";
		
		System.out.println("Update sql statement === " + sqlQuery);
		jdbcTemplate = new JdbcTemplate(getDataSource());
		int count=jdbcTemplate.update(sqlQuery, userId);
		try {
			dataSource.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public String updateUser(User user) {
			String sqlQuery="UPDATE user SET userName =?,password =?,firstName =?,lastName =?,type =? WHERE userId =?";
			
			System.out.println("Update sql statement === " + sqlQuery);
			jdbcTemplate = new JdbcTemplate(getDataSource());
			jdbcTemplate.update(sqlQuery, user.getUserName(),user.getPassword(),user.getFirstName(),user.getLastName(),user.getType());
			try {
				dataSource.getConnection().setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "success";
		}

	@Override
	public User findUser(String userId) {
		String sql = "Select * from User where userId =?";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		User user = (User)jdbcTemplate.queryForObject(
				sql, new Object[] { userId }, new UserMapper());
			
		return user;
	}

	@Override
	public boolean isValidUser(String username, String password) {
		String sql = "Select count(1) from user where username = ? and password = ?";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		int count = jdbcTemplate.queryForObject(
				sql, new Object[] { username,password },Integer.class);
		if(count>0)
		{
			return true;
		}
		return false;
		
	}
	

}
