package com.ambank.gst.web.dao;

import java.util.List;

import com.ambank.gst.web.model.User;

public interface ManageUserDAO {

	String createuser(User user);
	List<User> listUsers();
	String updateUser(User user);
	
}
