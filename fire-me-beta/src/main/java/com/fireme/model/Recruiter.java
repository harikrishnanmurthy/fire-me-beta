package com.fireme.model;

public class Recruiter {
String recruiterId;	
String userId;
String orgName;
String jobId;
public String getRecruiterId() {
	return recruiterId;
}
public void setRecruiterId(String recruiterId) {
	this.recruiterId = recruiterId;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getOrgName() {
	return orgName;
}
public void setOrgName(String orgName) {
	this.orgName = orgName;
}
public String getJobId() {
	return jobId;
}
public void setJobId(String jobId) {
	this.jobId = jobId;
}
@Override
public String toString() {
	return "Recruiter [recruiterId=" + recruiterId + ", userId=" + userId + ", orgName=" + orgName + ", jobId=" + jobId
			+ "]";
}


}
