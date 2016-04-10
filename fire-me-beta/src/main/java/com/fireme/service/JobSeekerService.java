package com.fireme.service;

import java.util.List;

import com.fireme.model.JobSeeker;

public interface JobSeekerService {
	public void updateJobSeeker(JobSeeker jobseeker);
	public List<JobSeeker> listJobSeekers();
}

