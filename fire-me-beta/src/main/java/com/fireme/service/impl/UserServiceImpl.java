package com.fireme.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fireme.dao.JobSeekerDao;
import com.fireme.dao.UserDao;
import com.fireme.model.JobSeeker;
import com.fireme.model.User;
import com.fireme.service.UserService;

public class UserServiceImpl implements UserService {
@Autowired
UserDao usersDao;
@Autowired 
JobSeekerDao jobSeekerDao;
	@Override
	public boolean isValidUser(String username, String password) throws SQLException {
		return usersDao.isValidUser(username, password);

	}
	@Override
	public void registerJobSeeker(User user, JobSeeker jobSeeker) {
		usersDao.createuser(user);
		jobSeekerDao.createJobSeeker(jobSeeker);
	}
public int createUserIdSequence()
   {
	return 0;
	}
@Override
public void getUsers() {
	for (User user : usersDao.listUsers()) {
		System.err.println(">>>"+user);
	}
}
}
