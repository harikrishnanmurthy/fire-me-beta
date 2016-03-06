package com.ambank.gst.web.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ambank.gst.web.model.DbRole;
import com.ambank.gst.web.model.User;
import com.ambank.gst.web.util.DbRoleMapper;


public class ManageUserDAOImpl implements ManageUserDAO{

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
	public String createuser(User user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO hari.user(user_id,name,emp_num,domain_id,role_id,approver1_id,approver2_id,sourcesystem)VALUES(?,?,?,?,?,?,?,?);";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sql, new Object[] {user.getLanId(),user.getName(),user.getLanId(),Integer.parseInt(user.getDomainId()),Integer.parseInt(user.getUserRole()),user.getApproverId1(),user.getApproverId2(),user.getSourceSystem() });
	 	try {
			dataSource.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<User>();
		String sql = "Select * from hari.user;";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		List<DbRole> dbRoleList = jdbcTemplate.query(sql,new DbRoleMapper());
		for(DbRole dbrole : dbRoleList){
			User user = new User(dbrole.getDomainId(), dbrole.getUserId(), dbrole.getName(),dbrole.getUserId(),dbrole.getRoleId(), dbrole.getApproverId1(), dbrole.getApproverId2(), dbrole.getSourceSystem());
			userList.add(user);
		}
		return userList;
	}

	@Override
	public String updateUser(User user) {
		// TODO Auto-generated method stub
				
		String sqlQuery="UPDATE hari.user SET name =?,emp_num =?,domain_id =?,role_id =?,approver1_id =?,approver2_id =?,sourcesystem =? WHERE user_id =?";
		
		System.out.println("Update sql statement === " + sqlQuery);
		jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sqlQuery, user.getName(),user.getEmployeeNo(),Integer.parseInt(user.getDomainId()),Integer.parseInt(user.getUserRole()),user.getApproverId1(),user.getApproverId2(),user.getSourceSystem(), user.getLanId());
		try {
			dataSource.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}


}
