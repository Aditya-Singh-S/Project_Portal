package com.cts.application.service;

import java.util.List;

import com.cts.application.entity.Application;

public interface ApplicationService {
	
	Application addApplication(int empid, int projectid);
	
	String approveApplication(int id, String feedback);
	
	String denyApplication(int id);
	
	List<Application> viewAllApplication();
	
	List<Application> viewProjectApplication(int projectid);
	
	Application viewApplication(int applicationid);
}
