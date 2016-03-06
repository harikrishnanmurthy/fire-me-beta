package com.ambank.gst.web.model;

public class GSTMappingModel {
	
	String srcSysCode;
	String primaryTransactionCode;
	String secondaryTransactionCode;
	String ieInd;
	String tiFlag;
	String taxCode0;
	String transactionDesc;
	String userId;
	String effectiveDate;
	String endDate;
	public String getSrcSysCode() {
		return srcSysCode;
	}
	public void setSrcSysCode(String srcSysCode) {
		this.srcSysCode = srcSysCode;
	}
	public String getIeInd() {
		return ieInd;
	}
	public void setIeInd(String ieInd) {
		this.ieInd = ieInd;
	}
	public String getTiFlag() {
		return tiFlag;
	}
	public void setTiFlag(String tiFlag) {
		this.tiFlag = tiFlag;
	}
	public String getTaxCode0() {
		return taxCode0;
	}
	public void setTaxCode0(String taxCode0) {
		this.taxCode0 = taxCode0;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public GSTMappingModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPrimaryTransactionCode() {
		return primaryTransactionCode;
	}
	public void setPrimaryTransactionCode(String primaryTransactionCode) {
		this.primaryTransactionCode = primaryTransactionCode;
	}
	public String getSecondaryTransactionCode() {
		return secondaryTransactionCode;
	}
	public void setSecondaryTransactionCode(String secondaryTransactionCode) {
		this.secondaryTransactionCode = secondaryTransactionCode;
	}
	public String getTransactionDesc() {
		return transactionDesc;
	}
	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public GSTMappingModel(String srcSysCode, String primaryTransactionCode,
			String secondaryTransactionCode, String ieInd, String tiFlag,
			String taxCode0, String transactionDesc, String userId,
			String effectiveDate, String endDate) {
		super();
		this.srcSysCode = srcSysCode;
		this.primaryTransactionCode = primaryTransactionCode;
		this.secondaryTransactionCode = secondaryTransactionCode;
		this.ieInd = ieInd;
		this.tiFlag = tiFlag;
		this.taxCode0 = taxCode0;
		this.transactionDesc = transactionDesc;
		this.userId = userId;
		this.effectiveDate = effectiveDate;
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "GSTMappingModel [srcSysCode=" + srcSysCode
				+ ", primaryTransactionCode=" + primaryTransactionCode
				+ ", secondaryTransactionCode=" + secondaryTransactionCode
				+ ", ieInd=" + ieInd + ", tiFlag=" + tiFlag + ", taxCode0="
				+ taxCode0 + ", transactionDesc=" + transactionDesc
				+ ", userId=" + userId + ", effectiveDate=" + effectiveDate
				+ ", endDate=" + endDate + "]";
	}
	
		
}
