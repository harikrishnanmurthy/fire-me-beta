package com.fireme.dao;

import java.util.List;

import com.fireme.model.JobSeeker;

public interface JobSeekerDao {
	String createJobSeeker(JobSeeker jobSeeker);
	List<JobSeeker> listJobSeekers();
	int deleteJobseeker(String jobSeekerId);
	String updateJobseeker(JobSeeker jobseeker);
	JobSeeker findJobSeeker(String userId);
}
