package com.fireme.model;

public class Job {
	
String company;
String jobDescription;
String jobId;

public Job(String company, String jobDescription, String jobId) {
	super();
	this.company = company;
	this.jobDescription = jobDescription;
	this.jobId = jobId;
}

public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getJobDescription() {
	return jobDescription;
}
public void setJobDescription(String jobDescription) {
	this.jobDescription = jobDescription;
}
public String getJobId() {
	return jobId;
}
public void setJobId(String jobId) {
	this.jobId = jobId;
}

@Override
public String toString() {
	return "Job [company=" + company + ", jobDescription=" + jobDescription + ", jobId=" + jobId + "]";
}

}
