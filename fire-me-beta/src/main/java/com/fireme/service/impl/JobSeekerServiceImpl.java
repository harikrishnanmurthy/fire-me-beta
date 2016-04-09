package com.fireme.service.impl;

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

}
