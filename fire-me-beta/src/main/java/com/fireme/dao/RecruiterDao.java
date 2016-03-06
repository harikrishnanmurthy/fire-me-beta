package com.fireme.dao;

import java.util.List;

import com.fireme.model.Recruiter;

public interface RecruiterDao {
	String createRecruiter(Recruiter recruiter);
	List<Recruiter> listRecruiters(String jobId);
	int deleteRecruiter(String recruiterId);
	String updateRecruiter(Recruiter recruiter);

}
