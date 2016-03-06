package com.ambank.gst.web.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ambank.gst.web.model.DbRole;

public class DbRoleMapper implements RowMapper<DbRole> {
	
	public DbRole mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DbRole role=new DbRole();		
		        
		role.setRoleId(rs.getString("role_id"));
		role.setUserId(rs.getString("user_id"));
		role.setName(rs.getString("name"));
		role.setSourceSystem(rs.getString("sourcesystem"));
		role.setEmployeeNo(rs.getString("emp_num"));
		role.setDomainId(rs.getString("domain_id"));
		role.setApproverId1(rs.getString("approver1_id"));
		role.setApproverId2(rs.getString("approver2_id"));
		role.setLoggedIn(rs.getString("isloggedin"));
		
		return role;
	}

}
