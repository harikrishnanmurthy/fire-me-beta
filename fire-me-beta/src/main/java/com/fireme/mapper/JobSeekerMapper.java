package com.fireme.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.fireme.model.JobSeeker;
import com.fireme.model.Application;
import com.fireme.model.User;

public class JobSeekerMapper implements RowMapper<JobSeeker> {
	
	public JobSeeker mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		JobSeeker jobSeeker=new JobSeeker();		
		        
		jobSeeker.setJobseekerId(rs.getString("JOB_SEEKER_ID"));
		jobSeeker.setCompanyName(rs.getString("COMPANY_NAME"));
		jobSeeker.setDesignation(rs.getString("DESIGNATION"));
		jobSeeker.setCurrentSalary(Double.parseDouble(rs.getString("CURR_SAL")));
		jobSeeker.setExpSalary(Double.parseDouble(rs.getString("EXP_SAL")));
		jobSeeker.setHasNoc(Boolean.parseBoolean(rs.getString("HAS_NOC")));
		jobSeeker.setNoticePeriod(Integer.parseInt(rs.getString("NOTICE_PERIOD")));
		
	    return jobSeeker;
	}
}
