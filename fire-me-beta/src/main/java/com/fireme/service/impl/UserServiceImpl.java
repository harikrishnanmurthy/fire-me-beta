package com.fireme.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.fireme.dao.JobSeekerDao;
import com.fireme.dao.UserDao;
import com.fireme.model.JobSeeker;
import com.fireme.model.User;
import com.fireme.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService {

	@Inject
	UserDao usersDao;

	@Inject
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

	public int createUserIdSequence() {
		return 0;
	}

	@Override
	public void getUsers() {
		List<User> userList = usersDao.listUsers();
		for (User user : userList) {
			System.out.println(">>>" + user);
		}
	}
}
