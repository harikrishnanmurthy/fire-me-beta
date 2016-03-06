package com.fireme.service;

import java.sql.SQLException;

import com.fireme.model.JobSeeker;
import com.fireme.model.User;

public interface UserService {
	public boolean isValidUser(String username, String password) throws SQLException;
    public void registerJobSeeker(User user,JobSeeker jobSeeker);
    public void getUsers();
    
}

