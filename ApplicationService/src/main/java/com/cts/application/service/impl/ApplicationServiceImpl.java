package com.cts.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.application.entity.Application;
import com.cts.application.repository.ApplicationRepository;
import com.cts.application.service.AllotmentService;
import com.cts.application.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	
	@Autowired
	private AllotmentService allotmentService;
	
	private ApplicationRepository applicationRepo;
	
	@Autowired
	public ApplicationServiceImpl(ApplicationRepository applicationRepo) {
		this.applicationRepo = applicationRepo;
	}

	@Override
	public Application addApplication(int empid, int projectid) {
		Application application = new Application();
		application.setEmpid(empid);
		application.setProjectid(projectid);
		return applicationRepo.save(application);
	}

	@Override
	public String approveApplication(int id, String feedback) {
		Application application = applicationRepo.findById(id).get();
		application.setStatus("APPROVED");
		applicationRepo.save(application);
		
		allotmentService.addAllotment(application, feedback);
		
		return "Application Approved";
	}

	@Override
	public String denyApplication(int id) {
		Application application = applicationRepo.findById(id).get();
		application.setStatus("REJECTED");
		applicationRepo.save(application);
		return "Application Rejected";
	}

	@Override
	public List<Application> viewAllApplication() {
		return applicationRepo.findAll();
	}

	@Override
	public Application viewApplication(int applicationid) {
		return applicationRepo.findById(applicationid).get();
	}

	@Override
	public List<Application> viewProjectApplication(int projectid) {
		return applicationRepo.findByProjectid(projectid);
	}

}
