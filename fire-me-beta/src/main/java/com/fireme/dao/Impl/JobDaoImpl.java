package com.fireme.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.fireme.dao.JobDao;
import com.fireme.mapper.JobMapper;
import com.fireme.model.Job;
import com.fireme.model.JobSeeker;

@Component
public class JobDaoImpl implements JobDao{
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
	public String createJob(Job job) {
		String sql = "INSERT INTO JOB(User_Id,Job_Title,Job_Desc,Job_Skill,Job_Salary,Job_Contact_Email,Job_Contact_Phone,Job_Type,Job_Status)VALUES(?,?,?,?,?,?,?,?,?)";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sql,
				new Object[] {job.getUserId(), job.getTitle(),
						job.getDescription(), job.getSkill(), job.getSalary(),
						job.getEmail(), job.getPhoneNo(), job.getType(), "A"});
		try {
			dataSource.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Override
	public List<Job> listJobsPostedByUser(String userId) {
		String sql = "Select * from JOB where User_Id=?";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		List<Job> jobList = jdbcTemplate.query(sql,new Object[]{userId}, new JobMapper());
		return jobList;
	}

}
