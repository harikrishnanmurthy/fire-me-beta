package com.fireme.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fireme.dao.JobSeekerDao;
import com.fireme.mapper.JobSeekerMapper;
import com.fireme.mapper.UserMapper;
import com.fireme.model.Application;
import com.fireme.model.JobSeeker;
import com.fireme.model.User;

public class JobSeekerDaoImpl implements JobSeekerDao{
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
	public String updateJobseeker(JobSeeker jobseeker) {
String sqlQuery="UPDATE JOBSEEKER SET jobId =?,userId =?,currentSalary =?,expSalary =?,companyName =?,designation =?,hasNoc =?,noticePeriod=? WHERE jobseekerId =?";
		
		System.out.println("Update sql statement === " + sqlQuery);
		jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sqlQuery, jobseeker.getJobId(),jobseeker.getUserId(),jobseeker.getCurrentSalary(),jobseeker.getExpSalary(),jobseeker.getCompanyName(),jobseeker.getDesignation(),jobseeker.isHasNoc(),jobseeker.getNoticePeriod(),jobseeker.getJobseekerId());
		try {
			dataSource.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Override
	public String createJobSeeker(JobSeeker jobSeeker) {
		String sql = "INSERT INTO JOBSEEKER(jobseekerId,jobId,userId,currentSalary,expSalary,companyName,designation,hasNoc,noticePeriod)VALUES(?,?,?,?,?,?,?,?,?)";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sql, new Object[] {jobSeeker.getJobseekerId(),jobSeeker.getJobId(),jobSeeker.getUserId(),jobSeeker.getCurrentSalary(),jobSeeker.getExpSalary(),jobSeeker.getCompanyName(),jobSeeker.getDesignation(),jobSeeker.isHasNoc(),jobSeeker.getNoticePeriod()
				});
	 	try {
			dataSource.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Override
	public List<JobSeeker> listJobSeekers(String jobId) {
		String sql = "Select * from JobSeeker where jobId=?";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		List<JobSeeker> jobSeekerList = jdbcTemplate.query(sql,new JobSeekerMapper());
		return jobSeekerList;
	}

	@Override
	public int deleteJobseeker(String jobSeekerId) {
String sqlQuery="DELETE JOBSEEKER where jobSeekerId =?";
		
		System.out.println("Update sql statement === " + sqlQuery);
		jdbcTemplate = new JdbcTemplate(getDataSource());
		int count=jdbcTemplate.update(sqlQuery, jobSeekerId);
		try {
			dataSource.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public JobSeeker findJobSeeker(String userId) {
		String sql = "SELECT * FROM JOBSEEKER WHERE userId = ?";
		 
		JobSeeker jobSeeker = (JobSeeker)getJdbcTemplate().queryForObject(
				sql, new Object[] { userId }, new JobSeekerMapper());
			
		return jobSeeker;
	}

}
