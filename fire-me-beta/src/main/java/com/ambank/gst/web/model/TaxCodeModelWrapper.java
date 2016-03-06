package com.ambank.gst.web.model;

import java.util.List;

public class TaxCodeModelWrapper {
	
	List<TaxCodeModel> taxCodeList;

	public List<TaxCodeModel> getTaxCodeList() {
		return taxCodeList;
	}

	public void setTaxCodeList(List<TaxCodeModel> taxCodeList) {
		this.taxCodeList = taxCodeList;
	}

	@Override
	public String toString() {
		return "TaxCodeModelWrapper [taxCodeList=" + taxCodeList + "]";
	}

	public TaxCodeModelWrapper(List<TaxCodeModel> taxCodeList) {
		super();
		this.taxCodeList = taxCodeList;
	}

	public TaxCodeModelWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
