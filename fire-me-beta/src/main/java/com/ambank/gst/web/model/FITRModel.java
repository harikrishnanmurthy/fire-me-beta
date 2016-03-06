package com.ambank.gst.web.model;

public class FITRModel {
	
	String taxCode;
	String fitr;
	String user;
	String effectiveDate;
	String endDate;
	
	public String getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	public String getFitr() {
		return fitr;
	}
	public void setFitr(String fitr) {
		this.fitr = fitr;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
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
	@Override
	public String toString() {
		return "TaxCodeModel [taxCode=" + taxCode + ", fitr=" + fitr + ", user=" + user + ", effectiveDate="
				+ effectiveDate + ", endDate=" + endDate + "]";
	}
	public FITRModel(String taxCode, String fitr,
			String user, String effectiveDate, String endDate) {
		super();
		this.taxCode = taxCode;
		this.fitr = fitr;
		this.user = user;
		this.effectiveDate = effectiveDate;
		this.endDate = endDate;
	}
	public FITRModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
