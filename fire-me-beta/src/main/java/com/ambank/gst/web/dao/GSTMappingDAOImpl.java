package com.ambank.gst.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ambank.gst.web.model.GSTMappingModel;
import com.ambank.gst.web.util.GSTMapper;

public class GSTMappingDAOImpl implements GSTMappingDAO{

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
	public List<GSTMappingModel> listGSTMappingEntries() {
		// TODO Auto-generated method stub
		String sql = "Select * from hari.gst_workflow;";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		List<GSTMappingModel> modelList = jdbcTemplate.query(sql,new GSTMapper());
		return modelList;
	}

}
