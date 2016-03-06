package com.ambank.gst.web.model;

import java.util.List;

public class FITRModelWrapper {
	
	List<FITRModel> fitrList;

	public List<FITRModel> getFitrList() {
		return fitrList;
	}

	public void setFitrList(List<FITRModel> fitrList) {
		this.fitrList = fitrList;
	}

	@Override
	public String toString() {
		return "FITRModelWrapper [fitrList=" + fitrList + "]";
	}

	public FITRModelWrapper(List<FITRModel> fitrList) {
		super();
		this.fitrList = fitrList;
	}

	public FITRModelWrapper() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
}
