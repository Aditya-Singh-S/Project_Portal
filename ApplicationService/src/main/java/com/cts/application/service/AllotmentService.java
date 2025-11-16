package com.cts.application.service;

import java.util.List;

import com.cts.application.entity.Application;
import com.cts.application.entity.ProjectAllotment;

public interface AllotmentService {
	
	ProjectAllotment addAllotment(Application application, String feedback);
	
	List<ProjectAllotment> viewAll();
}
