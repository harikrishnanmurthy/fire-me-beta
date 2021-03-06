package com.fireme.mapper;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fireme.model.JobSeeker;

public class JobSeekerMapper implements RowMapper<JobSeeker> {
	
	public JobSeeker mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		JobSeeker jobSeeker=new JobSeeker();		
		        
		jobSeeker.setUserName(rs.getString("USERNAME"));
		jobSeeker.setNoticePeriod(Integer.parseInt(rs.getString("NOTICE_PERIOD")));
		jobSeeker.setDesignation(rs.getString("DESIGNATION"));
		jobSeeker.setExperience(rs.getDouble("EXP"));
		jobSeeker.setCurrentSalary(rs.getDouble("CUR_SALARY"));
		jobSeeker.setExpSalary(rs.getDouble("EXP_SALARY"));
		jobSeeker.setProfileName(rs.getString("PROFILE_NAME"));
		if(null!=rs.getBlob("PROFILE")){
			Blob blob = rs.getBlob("PROFILE");
			int blobLength = (int) blob.length();  
			byte[] blobAsBytes = blob.getBytes(1, blobLength);
			jobSeeker.setProfile(blobAsBytes);
			blob.free();
		}
		
		
	    return jobSeeker;
	}
}
