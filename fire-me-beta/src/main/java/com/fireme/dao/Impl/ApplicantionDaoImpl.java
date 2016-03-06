package com.fireme.dao.Impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.fireme.dao.JobSeekerDao;
import com.fireme.model.JobSeeker;

@Component
public class ApplicantionDaoImpl implements JobSeekerDao{
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
//	@Override
//	public String createApplicant(JobSeeker applicant) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<JobSeeker> listApplicants() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int deleteApplicant(JobSeeker applicant) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public String updateApplicant(JobSeeker applicant) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public String createJobSeeker(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobSeeker> listJobSeekers(String jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteJobseeker(String jobSeekerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String updateJobseeker(JobSeeker jobseeker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobSeeker findJobSeeker(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
