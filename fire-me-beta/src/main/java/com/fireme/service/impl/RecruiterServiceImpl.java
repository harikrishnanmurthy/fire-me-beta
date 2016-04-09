package com.fireme.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.fireme.dao.RecruiterDao;
import com.fireme.model.Recruiter;
import com.fireme.service.RecruiterService;

@Component("recruiterService")
public class RecruiterServiceImpl implements RecruiterService {
	
	@Inject
	RecruiterDao recruiterDao;
	
	@Override
	public void updateRecruiter(Recruiter recruiter) {
		recruiterDao.updateRecruiter(recruiter);
	}

}
