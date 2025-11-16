package com.cts.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.application.entity.Application;
import com.cts.application.entity.ProjectAllotment;
import com.cts.application.repository.ProjectAllotmentRepository;
import com.cts.application.service.AllotmentService;

@Service
public class AllotmentServiceImpl implements AllotmentService {
	
	@Autowired
	private ProjectAllotmentRepository allotmentRepo;

	@Override
	public ProjectAllotment addAllotment(Application application, String feedback) {
		ProjectAllotment newAllotment = new ProjectAllotment();
		newAllotment.setApplicationid(application.getApplicationid());
		newAllotment.setEmpid(application.getEmpid());
		newAllotment.setProjectid(application.getProjectid());
		newAllotment.setStatus(application.getStatus());
		newAllotment.setFeedback(feedback);
		
		allotmentRepo.save(newAllotment);
		
		return newAllotment;
	}

	@Override
	public List<ProjectAllotment> viewAll() {
		return allotmentRepo.findAll();
	}

}
