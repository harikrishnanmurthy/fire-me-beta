package com.fireme.service;

import java.util.List;

import com.fireme.model.Job;

public interface JobService {
	public void createJob(Job job);
	List<Job> listJobsPostedByUser(String userId);
}

