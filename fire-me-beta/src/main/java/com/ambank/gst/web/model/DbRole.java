package com.ambank.gst.web.model;


public class DbRole {
	
	String roleId;
	String name;
	String userId;
	String sourceSystem;
	String employeeNo;
	String domainId;
	String approverId1;
	String approverId2;
	String isLoggedIn;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getDomainId() {
		return domainId;
	}
	public void setDomainId(String domainId) {
		this.domainId = domainId;
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

	public DbRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(String isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	@Override
	public String toString() {
		return "DbRole [roleId=" + roleId + ", name=" + name + ", userId="
				+ userId + ", sourceSystem=" + sourceSystem + ", employeeNo="
				+ employeeNo + ", domainId=" + domainId + ", approverId1="
				+ approverId1 + ", approverId2=" + approverId2
				+ ", isLoggedIn=" + isLoggedIn + "]";
	}
	public DbRole(String roleId, String name, String userId,
			String sourceSystem, String employeeNo, String domainId,
			String approverId1, String approverId2, String isLoggedIn) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.userId = userId;
		this.sourceSystem = sourceSystem;
		this.employeeNo = employeeNo;
		this.domainId = domainId;
		this.approverId1 = approverId1;
		this.approverId2 = approverId2;
		this.isLoggedIn = isLoggedIn;
	}



}