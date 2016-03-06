package com.ambank.gst.web.model;

public class User {

	String domainId;
	String lanId;
	String name;
	String employeeNo;
	String userRole;
	String approverId1;
	String approverId2;
	String sourceSystem;
	
	
	public String getDomainId() {
		return domainId;
	}
	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
	public String getLanId() {
		return lanId;
	}
	public void setLanId(String lanId) {
		this.lanId = lanId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getApproverId1() {
		return approverId1;
	}
	public void setApproverId1(String approverId1) {
		this.approverId1 = approverId1;
	}
	public String getApproverId2() {
		return approverId2;
	}
	public void setApproverId2(String approverId2) {
		this.approverId2 = approverId2;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	@Override
	public String toString() {
		return "User [domainId=" + domainId + ", lanId=" + lanId + ", name="
				+ name + ", userRole=" + userRole + ", approverId1="
				+ approverId1 + ", approverId2=" + approverId2
				+ ", sourceSystem=" + sourceSystem + ", employeeNo="
				+ employeeNo + "]";
	}
	public User(String domainId, String lanId, String name, String employeeNo,String userRole,
			String approverId1, String approverId2, String sourceSystem) {
		super();
		this.domainId = domainId;
		this.lanId = lanId;
		this.name = name;
		this.employeeNo = employeeNo;
		this.userRole = userRole;
		this.approverId1 = approverId1;
		this.approverId2 = approverId2;
		this.sourceSystem = sourceSystem;
		
	}
}
