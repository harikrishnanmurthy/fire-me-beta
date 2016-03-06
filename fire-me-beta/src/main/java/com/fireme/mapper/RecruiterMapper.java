package com.fireme.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fireme.model.Recruiter;

public class RecruiterMapper implements RowMapper<Recruiter> {
	
	public Recruiter mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Recruiter recruiter=new Recruiter();		
		        
		recruiter.setRecruiterId(rs.getString("RECRUITERID"));
		recruiter.setOrgName(rs.getString("ORGNAME"));
		recruiter.setUserId(rs.getString("USERID"));
		recruiter.setJobId(rs.getString("JOBID"));
	    return recruiter;
	}
}
