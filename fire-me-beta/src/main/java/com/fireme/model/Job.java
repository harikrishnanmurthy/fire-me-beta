package com.fireme.model;

public class Job {
	
String jobId;
String orgName;
String description;
String email;
String phoneNo;
String type;
String title;
String webpage;
String skill;
String salary;

public Job(String jobId, String orgName, String description, String email, String phoneNo, String type, String title,
		String webpage, String skill, String salary) {
	super();
	this.jobId = jobId;
	this.orgName = orgName;
	this.description = description;
	this.email = email;
	this.phoneNo = phoneNo;
	this.type = type;
	this.title = title;
	this.webpage = webpage;
	this.skill = skill;
	this.salary = salary;
}

public Job( String orgName, String title, String jobId){
	this.orgName = orgName;
	this.title = title;
	this.jobId = jobId;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhoneNo() {
	return phoneNo;
}

public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getWebpage() {
	return webpage;
}

public void setWebpage(String webpage) {
	this.webpage = webpage;
}

public String getSkill() {
	return skill;
}

public void setSkill(String skill) {
	this.skill = skill;
}

public String getSalary() {
	return salary;
}

public void setSalary(String salary) {
	this.salary = salary;
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
	return "Job [orgName=" + orgName + ", jobDescription=" + description + ", jobId=" + jobId + "]";
}

}
