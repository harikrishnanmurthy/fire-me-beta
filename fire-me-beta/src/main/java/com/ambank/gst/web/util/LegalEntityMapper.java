package com.ambank.gst.web.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ambank.gst.web.model.LegalEntityModel;

public class LegalEntityMapper implements RowMapper<LegalEntityModel> {
	
	public LegalEntityModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		LegalEntityModel model=new LegalEntityModel();		
		        
		model.setEntityCode(rs.getString("ENTITY_CODE"));
		model.setEntityName(rs.getString("ENTITY_NAME"));
		model.setEntityDesc(rs.getString("ENTITY_DESC"));
		model.setBusRegNum(rs.getString("BUS_REG_NUM"));
		model.setGstRegNum(rs.getString("GST_REG_NUM"));
		model.setUserId(rs.getString("CORRECTED_BY"));
		model.setEffectiveStartDate(rs.getString("EFF_START"));
		model.setEndDate(rs.getString("EFF_END"));
		
		return model;
	}

}
