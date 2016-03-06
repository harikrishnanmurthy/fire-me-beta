package com.ambank.gst.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ambank.gst.web.model.FITRModel;
import com.ambank.gst.web.util.FITRMapper;


public class FITRDAOImpl implements FITRDAO{

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
	public List<FITRModel> listFITR() {
		// TODO Auto-generated method stub
		String sql = "Select * from hari.scd_fitr;";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		List<FITRModel> modelList = jdbcTemplate.query(sql,new FITRMapper());
		return modelList;
	}

}
