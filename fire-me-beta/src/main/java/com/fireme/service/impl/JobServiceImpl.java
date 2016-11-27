package com.fireme.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.fireme.dao.JobDao;
import com.fireme.model.Job;
import com.fireme.service.JobService;

@Component("jobService")
public class JobServiceImpl implements JobService {

	@Inject
	JobDao jobDao;

	@Override
	public void createJob(Job job) {
		jobDao.createJob(job);
	}

	@Override
	public List<Job> listJobsPostedByUser(String userId) {
		return jobDao.listJobsPostedByUser(userId);
	}
}
