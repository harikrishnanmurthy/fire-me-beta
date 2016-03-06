package com.ambank.gst.web.model;

import java.util.List;

public class GSTMappingModelWrapper {

	List<GSTMappingModel> mappingModelList;

	public List<GSTMappingModel> getMappingModelList() {
		return mappingModelList;
	}

	public void setMappingModelList(List<GSTMappingModel> mappingModelList) {
		this.mappingModelList = mappingModelList;
	}

	@Override
	public String toString() {
		return "GSTMappingModelWrapper [mappingModelList=" + mappingModelList
				+ "]";
	}

	public GSTMappingModelWrapper(List<GSTMappingModel> mappingModelList) {
		super();
		this.mappingModelList = mappingModelList;
	}

	public GSTMappingModelWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
}
