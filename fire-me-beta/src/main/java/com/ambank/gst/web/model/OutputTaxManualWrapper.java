package com.ambank.gst.web.model;

import java.util.List;

public class OutputTaxManualWrapper {

	List<CustomerOutputTaxManual> custTaxManual;
	List<TransactionOutputTaxManual> transTaxManual;
	
	public List<CustomerOutputTaxManual> getCustTaxManual() {
		return custTaxManual;
	}
	public void setCustTaxManual(List<CustomerOutputTaxManual> custTaxManual) {
		this.custTaxManual = custTaxManual;
	}
	public List<TransactionOutputTaxManual> getTransTaxManual() {
		return transTaxManual;
	}
	public void setTransTaxManual(List<TransactionOutputTaxManual> transTaxManual) {
		this.transTaxManual = transTaxManual;
	}
}
