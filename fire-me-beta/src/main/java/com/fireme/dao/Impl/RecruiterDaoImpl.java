package com.fireme.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.fireme.dao.RecruiterDao;
import com.fireme.mapper.JobSeekerMapper;
import com.fireme.mapper.RecruiterMapper;
import com.fireme.model.JobSeeker;
import com.fireme.model.Recruiter;

@Component
public class RecruiterDaoImpl implements RecruiterDao{
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
	public String createRecruiter(Recruiter recruiter) {
		String sql = "INSERT INTO RECRUITER(USERNAME,ORG_NAME)VALUES(?,?)";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sql, new Object[] {recruiter.getUserName(),recruiter.getOrgName()});
	 	try {
			dataSource.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Override
	public List<Recruiter> listRecruiters(String jobId) {
		String sql = "Select * from RECRUITER where jobId=?";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		List<Recruiter> recruiterList = jdbcTemplate.query(sql,new RecruiterMapper());
		return recruiterList;
	}

	@Override
	public int deleteRecruiter(String recruiterId) {
String sqlQuery="DELETE RECRUITER where recruiterid =?";
		
		System.out.println("Update sql statement === " + sqlQuery);
		jdbcTemplate = new JdbcTemplate(getDataSource());
		int count=jdbcTemplate.update(sqlQuery, recruiterId);
		try {
			dataSource.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public String updateRecruiter(Recruiter recruiter) {
String sqlQuery="UPDATE RECRUITER SET jobId =?,userId =?,orgName =?WHERE recruiterid =?";
		
		System.out.println("Update sql statement === " + sqlQuery);
		jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sqlQuery,recruiter.getUserId(),recruiter.getOrgName(),recruiter.getRecruiterId());
		try {
			dataSource.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}
	

}
