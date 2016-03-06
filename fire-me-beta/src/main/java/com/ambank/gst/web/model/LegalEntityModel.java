package com.ambank.gst.web.model;

public class LegalEntityModel {
	
	String entityCode;
	String entityName;
	String entityDesc;
	String busRegNum;
	String gstRegNum;
	String userId;
	String effectiveStartDate;
	String endDate;
	
	public String getEntityCode() {
		return entityCode;
	}
	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getEntityDesc() {
		return entityDesc;
	}
	public void setEntityDesc(String entityDesc) {
		this.entityDesc = entityDesc;
	}
	public String getBusRegNum() {
		return busRegNum;
	}
	public void setBusRegNum(String busRegNum) {
		this.busRegNum = busRegNum;
	}
	public String getGstRegNum() {
		return gstRegNum;
	}
	public void setGstRegNum(String gstRegNum) {
		this.gstRegNum = gstRegNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEffectiveStartDate() {
		return effectiveStartDate;
	}
	public void setEffectiveStartDate(String effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public LegalEntityModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LegalEntityModel [entityCode=" + entityCode + ", entityName="
				+ entityName + ", entityDesc=" + entityDesc + ", busRegNum="
				+ busRegNum + ", gstRegNum=" + gstRegNum + ", userId=" + userId
				+ ", effectiveStartDate=" + effectiveStartDate + ", endDate="
				+ endDate + "]";
	}
	public LegalEntityModel(String entityCode, String entityName,
			String entityDesc, String busRegNum, String gstRegNum,
			String userId, String effectiveStartDate, String endDate) {
		super();
		this.entityCode = entityCode;
		this.entityName = entityName;
		this.entityDesc = entityDesc;
		this.busRegNum = busRegNum;
		this.gstRegNum = gstRegNum;
		this.userId = userId;
		this.effectiveStartDate = effectiveStartDate;
		this.endDate = endDate;
	}

}
