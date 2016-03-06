package com.ambank.gst.web.model;

public class TaxCodeModel {
	
	String taxCode;
	String taxRate;
	String taxInvoiceFlag;
	String taxCodeDesc;
	String user;
	String effectiveDate;
	String endDate;
	
	public String getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	public String getTaxCodeDesc() {
		return taxCodeDesc;
	}
	public void setTaxCodeDesc(String taxCodeDesc) {
		this.taxCodeDesc = taxCodeDesc;
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
	public TaxCodeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}
	public String getTaxInvoiceFlag() {
		return taxInvoiceFlag;
	}
	public void setTaxInvoiceFlag(String taxInvoiceFlag) {
		this.taxInvoiceFlag = taxInvoiceFlag;
	}
	@Override
	public String toString() {
		return "TaxCodeModel [taxCode=" + taxCode + ", taxRate=" + taxRate
				+ ", taxInvoiceFlag=" + taxInvoiceFlag + ", taxCodeDesc="
				+ taxCodeDesc + ", user=" + user + ", effectiveDate="
				+ effectiveDate + ", endDate=" + endDate + "]";
	}
	public TaxCodeModel(String taxCode, String taxRate, String taxInvoiceFlag,
			String taxCodeDesc, String user, String effectiveDate,
			String endDate) {
		super();
		this.taxCode = taxCode;
		this.taxRate = taxRate;
		this.taxInvoiceFlag = taxInvoiceFlag;
		this.taxCodeDesc = taxCodeDesc;
		this.user = user;
		this.effectiveDate = effectiveDate;
		this.endDate = endDate;
	}
	
	
}
