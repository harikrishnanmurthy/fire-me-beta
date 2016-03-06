package com.ambank.gst.web.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ambank.gst.web.model.TaxCodeModel;

public class TaxCodeMapper implements RowMapper<TaxCodeModel> {
	
	public TaxCodeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TaxCodeModel model=new TaxCodeModel();		
		        
		model.setTaxCode(rs.getString("TAX_CD"));
		model.setTaxRate(rs.getString("TAX_RT"));
		model.setTaxInvoiceFlag(rs.getString("TAX_INV_FLG"));
		model.setTaxCodeDesc(rs.getString("TAX_DESC"));
		model.setUser(rs.getString("CORRECTED_BY"));
		model.setEffectiveDate(rs.getString("EFF_START"));
		model.setEndDate(rs.getString("EFF_END"));
		
		return model;
	}

}
