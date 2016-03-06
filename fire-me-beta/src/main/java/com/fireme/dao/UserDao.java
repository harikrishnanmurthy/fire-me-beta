package com.fireme.dao;

import java.util.List;

import com.fireme.model.User;

public interface UserDao {
	String createUser(User user);
	List<User> listUsers();
	User findUser(String userId);
	int deleteUser(String userId);
	String updateUser(User user);
	boolean isValidUser(String username, String password);

}
