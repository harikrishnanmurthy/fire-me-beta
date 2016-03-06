package com.ambank.gst.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ambank.gst.web.model.FITRModel;
import com.ambank.gst.web.model.LegalEntityModel;
import com.ambank.gst.web.util.FITRMapper;
import com.ambank.gst.web.util.LegalEntityMapper;


public class LegalEntityDAOImpl implements LegalEntityDAO{

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
	public List<LegalEntityModel> listLegalEntity() {
		// TODO Auto-generated method stub
		String sql = "Select * from hari.gst_scd_entity;";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		List<LegalEntityModel> modelList = jdbcTemplate.query(sql,new LegalEntityMapper());
		return modelList;
	}

}
