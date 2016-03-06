package com.ambank.gst.web.model;

import java.util.List;

public class UserWrapper {

	List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "UserWrapper [userList=" + userList + "]";
	}

	public UserWrapper(List<User> userList) {
		super();
		this.userList = userList;
	}

	public UserWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
}
