package com.fireme.model;

public class Job {
	
String userId;
String orgName;
String description;
String email;
String phoneNo;
String type;
String title;
String skill;
String salary;
String status;

public Job(String userId, String orgName, String description, String email, String phoneNo, String type, String title,
		 String skill, String salary, String status) {
	super();
	this.userId = userId;
	this.orgName = orgName;
	this.description = description;
	this.email = email;
	this.phoneNo = phoneNo;
	this.type = type;
	this.title = title;
	this.skill = skill;
	this.salary = salary;
	this.status = status;
}

public Job( String orgName, String title, String userId){
	this.orgName = orgName;
	this.title = title;
	this.userId = userId;
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

public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}

@Override
public String toString() {
	return "Job [orgName=" + orgName + ", jobDescription=" + description + ", userId=" + userId + "]";
}

public Job() {
	super();
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}
}
