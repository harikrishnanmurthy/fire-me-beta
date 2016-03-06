package com.ambank.gst.web.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ambank.gst.web.model.DbRole;
import com.ambank.gst.web.model.TaxCodeModel;
import com.ambank.gst.web.model.User;
import com.ambank.gst.web.util.DbRoleMapper;
import com.ambank.gst.web.util.TaxCodeMapper;


public class TaxCodeDAOImpl implements TaxCodeDAO{

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
	public List<TaxCodeModel> listTaxCodes() {
		// TODO Auto-generated method stub
		String sql = "Select * from hari.tax_code;";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		List<TaxCodeModel> modelList = jdbcTemplate.query(sql,new TaxCodeMapper());
		return modelList;
	}

}
