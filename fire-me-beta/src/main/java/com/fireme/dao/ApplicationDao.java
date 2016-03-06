package com.fireme.dao;

import java.util.List;

import com.fireme.model.Application;

public interface ApplicationDao {
	String createApplications(Application application);
	List<Application> listApplications();
	int deleteApplication(Application application);
	String updateApplciation(Application application);

}
