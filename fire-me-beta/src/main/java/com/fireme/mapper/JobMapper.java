package com.fireme.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fireme.model.Job;
import com.fireme.model.User;

public class JobMapper implements RowMapper<Job> {
	
	public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Job job=new Job();		
		job.setUserId(rs.getString("User_Id"));
		job.setType(rs.getString("Job_Type"));
		job.setTitle(rs.getString("Job_Title"));
		job.setSkill(rs.getString("Job_Skill"));
		job.setSalary(rs.getString("Job_Salary"));
		job.setPhoneNo(rs.getString("Job_Contact_Phone"));
		job.setEmail(rs.getString("Job_Contact_Email"));
		job.setDescription(rs.getString("Job_Desc"));
		job.setStatus(rs.getString("Job_Status"));
		
		return job;
	}
}
