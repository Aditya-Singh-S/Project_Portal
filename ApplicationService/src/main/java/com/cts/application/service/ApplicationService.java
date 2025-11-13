package com.cts.application.service;

import java.util.List;

import com.cts.application.entity.Application;

public interface ApplicationService {
	
	Application addApplication(Application application);
	
	String approveApplication(int id);
	
	String denyApplication(int id);
	
	List<Application> viewAllApplication();
	
	Application viewApplication(int id);
}
