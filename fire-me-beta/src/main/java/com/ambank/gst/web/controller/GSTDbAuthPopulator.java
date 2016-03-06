package com.ambank.gst.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

import com.ambank.gst.web.model.DbRole;
import com.ambank.gst.web.util.DbRoleMapper;
import com.ambank.gst.web.util.LoggedInException;

public class GSTDbAuthPopulator implements UserDetailsContextMapper {

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
	public UserDetails mapUserFromContext(DirContextOperations ctx,
			String username, Collection<? extends GrantedAuthority> authorities) {
		
		System.out.println("---------------Am inside mapUserFromContext--------------------");
		List<SimpleGrantedAuthority> allAuthorities = new ArrayList<SimpleGrantedAuthority>();
	      for (GrantedAuthority auth : authorities) {
	        if (auth != null && !auth.getAuthority().isEmpty()) {
	           allAuthorities.add((SimpleGrantedAuthority) auth);
	        }
	      }
	      // add additional roles from the database table
	      List<SimpleGrantedAuthority> dbList = loadRolesFromDatabase(username);
	      allAuthorities.addAll(dbList);
	    //  return new User(username, "", true, true, true, true, allAuthorities);
	      if(dbList.get(3).getAuthority().equalsIgnoreCase("N")){
	    	  System.out.println("First time Login");
	    	  return new User(username, "", true, true, true, true, allAuthorities);
	      }else if(dbList.get(3).getAuthority().equalsIgnoreCase("Y")){
	    	  System.out.println("user Already logged In");
	    	  return new User(username, "", true, true, true, true, allAuthorities);
	      }
	      else{
	    	  return null;
	      }
		
	}
	
	// populating roles assigned to the user from AUTHORITIES table in DB
	private List<SimpleGrantedAuthority> loadRolesFromDatabase(String username) {
		
		System.out.println("---------------Am inside loadRolesFromDatabase--------------------");
		DbRole role = new DbRole();
		String sql = "select * from user where user_id = ?";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		role = jdbcTemplate.queryForObject(sql, new Object[] { username }, new DbRoleMapper());
		
		if(role.isLoggedIn().equalsIgnoreCase("N")){
			String updateSql = "update user set isloggedin= 'Y' where user_id = ?";
			jdbcTemplate.update(updateSql, new Object[] { username });
		}
		
		System.out.println("---------Printing role obj from Db--------" + role);
		System.out.println("---------Printing role id from Db--------" + role.getRoleId());
		System.out.println("---------Printing source system from Db--------" + role.getSourceSystem());
		
	 	try {
			dataSource.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			
		}
		
	    //"SELECT role_id FROM user WHERE user_id LIKE %username%";
		List<SimpleGrantedAuthority> authoritiess = new ArrayList<SimpleGrantedAuthority>();
		SimpleGrantedAuthority auth = new SimpleGrantedAuthority(String.valueOf(role.getRoleId()));
		SimpleGrantedAuthority approver1 = new SimpleGrantedAuthority(String.valueOf(role.getApproverId1()));
		SimpleGrantedAuthority approver2 = new SimpleGrantedAuthority(String.valueOf(role.getApproverId2()));
		SimpleGrantedAuthority loggedInFlag = new SimpleGrantedAuthority(String.valueOf(role.isLoggedIn()));
		authoritiess.add(auth);
		authoritiess.add(approver1);
		authoritiess.add(approver2);
		authoritiess.add(loggedInFlag);
		return authoritiess;
	
	   }

	@Override
	public void mapUserToContext(UserDetails user, DirContextAdapter ctx) {
		// TODO Auto-generated method stub
	}

}
