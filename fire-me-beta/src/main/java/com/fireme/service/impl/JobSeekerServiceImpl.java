package com.fireme.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.fireme.dao.JobSeekerDao;
import com.fireme.model.JobSeeker;
import com.fireme.service.JobSeekerService;

@Component("jobSeekerService")
public class JobSeekerServiceImpl implements JobSeekerService {

	@Inject
	JobSeekerDao jobSeekerDao;
	
	@Override
	public void updateJobSeeker(JobSeeker jobseeker) {
		jobSeekerDao.updateJobseeker(jobseeker);
	}

	@Override
	public List<JobSeeker> listJobSeekers() {
		return jobSeekerDao.listJobSeekers();
	}

	@Override
	public JobSeeker findJobSeeker(String userName) {
		// TODO Auto-generated method stub
		return jobSeekerDao.findJobSeeker(userName);
	}

}
