package com.ambank.gst.web.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ambank.gst.web.model.GSTMappingModel;
import com.ambank.gst.web.model.TaxCodeModel;

public class GSTMapper implements RowMapper<GSTMappingModel> {
	
	public GSTMappingModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		GSTMappingModel model=new GSTMappingModel();		
		  
		model.setSrcSysCode(rs.getString("SRC_SYS_ID"));
		model.setPrimaryTransactionCode(rs.getString("PRI_TXN_ID"));
		model.setSecondaryTransactionCode(rs.getString("SEC_TXN_ID"));
		model.setIeInd(rs.getString("IE_FLG"));
		model.setTiFlag(rs.getString("IO_FLG"));
		model.setTaxCode0(rs.getString("TAX_CD_0"));
		model.setTransactionDesc(rs.getString("TXN_DESC"));
		model.setUserId(rs.getString("CORRECTED_BY"));
		model.setEffectiveDate(rs.getString("EFF_START"));
		model.setEndDate(rs.getString("EFF_END"));
		return model;
	}

}
