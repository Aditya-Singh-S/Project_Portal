package com.cts.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.application.client.EmployeeClient;
import com.cts.application.dto.EmployeeResponse;
import com.cts.application.entity.Application;
import com.cts.application.entity.ProjectAllotment;
import com.cts.application.repository.ProjectAllotmentRepository;
import com.cts.application.service.AllotmentService;

@Service
public class AllotmentServiceImpl implements AllotmentService {
	
	@Autowired
	private EmployeeClient empClient;
	
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

	@Override
	public ProjectAllotment updateRoleFeedback(int id, String role, String feedback) {
		ProjectAllotment alloted = allotmentRepo.findById(id).get();
		alloted.setProjectrole(role);
		alloted.setFeedback(feedback);
		
		allotmentRepo.save(alloted);
		return alloted;
	}

	@Override
	public List<EmployeeResponse> projectEmployeeList(int projectid) {
		List<Integer> empIds = allotmentRepo.getProjectEmployeesId(projectid);
		
		List<EmployeeResponse> empList = new ArrayList<>();
		
		for(Integer empid : empIds) {
			EmployeeResponse emp = empClient.viewEmployeeDetails(empid).getBody();
			empList.add(emp);
		}
		
		return empList;
	}

}
