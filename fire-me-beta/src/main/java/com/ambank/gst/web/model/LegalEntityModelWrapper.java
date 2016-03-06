package com.ambank.gst.web.model;

import java.util.List;

public class LegalEntityModelWrapper {
	
	List<LegalEntityModel> entityModelList;

	public List<LegalEntityModel> getEntityModelList() {
		return entityModelList;
	}

	public void setEntityModelList(List<LegalEntityModel> entityModelList) {
		this.entityModelList = entityModelList;
	}

	@Override
	public String toString() {
		return "LegalEntityModelWrapper [entityModelList=" + entityModelList
				+ "]";
	}

	public LegalEntityModelWrapper(List<LegalEntityModel> entityModelList) {
		super();
		this.entityModelList = entityModelList;
	}

	public LegalEntityModelWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
}
