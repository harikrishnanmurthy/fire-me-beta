package com.ambank.gst.web.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ambank.gst.web.model.FITRModel;

public class FITRMapper implements RowMapper<FITRModel> {
	
	public FITRModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		FITRModel model=new FITRModel();		
		        
		model.setTaxCode(rs.getString("GST_TAX_CDE"));
		model.setFitr(rs.getString("FITR"));
		model.setUser(rs.getString("CORRECTED_BY"));
		model.setEffectiveDate(rs.getString("EFF_START"));
		model.setEndDate(rs.getString("EFF_END"));
		
		return model;
	}

}
