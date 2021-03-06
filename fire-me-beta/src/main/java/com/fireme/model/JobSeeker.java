package com.fireme.model;

import java.io.File;

public class JobSeeker extends User {

	String jobseekerId;
	Double currentSalary;
	Double expSalary;
	String companyName;
	String designation;
	boolean hasNoc;
	int noticePeriod;
	Double experience;
	String skills;
	byte[] profile;
	String profileName;

	public Double getCurrentSalary() {
		return currentSalary;
	}

	public void setCurrentSalary(Double currentSalary) {
		this.currentSalary = currentSalary;
	}

	public Double getExpSalary() {
		return expSalary;
	}

	public void setExpSalary(Double expSalary) {
		this.expSalary = expSalary;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public boolean isHasNoc() {
		return hasNoc;
	}

	public void setHasNoc(boolean hasNoc) {
		this.hasNoc = hasNoc;
	}

	public int getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public String getJobseekerId() {
		return jobseekerId;
	}

	public void setJobseekerId(String jobseekerId) {
		this.jobseekerId = jobseekerId;
	}

	@Override
	public String toString() {
		return "JobSeeker [jobseekerId=" + jobseekerId + ",currentSalary=" + currentSalary + ", expSalary=" + expSalary
				+ ", companyName=" + companyName + ", designation=" + designation + ", hasNoc=" + hasNoc
				+ ", noticePeriod=" + noticePeriod + "]";
	}

	public JobSeeker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobSeeker(String jobseekerId, String jobId, String userId, Double currentSalary, Double expSalary,
			String companyName, String designation, boolean hasNoc, int noticePeriod) {
		super();
		this.jobseekerId = jobseekerId;
		this.currentSalary = currentSalary;
		this.expSalary = expSalary;
		this.companyName = companyName;
		this.designation = designation;
		this.hasNoc = hasNoc;
		this.noticePeriod = noticePeriod;
	}

	public Double getExperience() {
		return experience;
	}

	public void setExperience(Double experience) {
		this.experience = experience;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public byte[] getProfile() {
		return profile;
	}

	public void setProfile(byte[] profile) {
		this.profile = profile;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

}
