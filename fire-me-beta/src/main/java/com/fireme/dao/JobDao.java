package com.fireme.dao;

import java.util.List;

import com.fireme.model.Job;

public interface JobDao {
	String createJob(Job job);
	List<Job> listJobsPostedByUser(String userId);
}
