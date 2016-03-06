package com.fireme.model;

public class Recruiter extends User {

	String recruiterId;
	String orgName;

	public String getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(String recruiterId) {
		this.recruiterId = recruiterId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Override
	public String toString() {
		return "Recruiter [recruiterId=" + recruiterId + ", orgName=" + orgName + "]";
	}

}
