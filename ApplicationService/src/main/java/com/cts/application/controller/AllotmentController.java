package com.cts.application.controller;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.application.dto.EmployeeResponse;
import com.cts.application.entity.ProjectAllotment;
import com.cts.application.service.AllotmentService;

@RestController
@RequestMapping("/allotment")
public class AllotmentController {
	
	@Autowired
	private AllotmentService allotmentService;
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<ProjectAllotment>> viewAll(){
		List<ProjectAllotment> allotments = allotmentService.viewAll();
		return ResponseEntity.ok(allotments);
	}
	
	@PutMapping("/updateRole/{applicationid}")
	public ResponseEntity<ProjectAllotment> updateRoleFeedback(@PathVariable("applicationid") int id,
			@RequestParam String role, @RequestParam String feedback){
		ProjectAllotment response = allotmentService.updateRoleFeedback(id, role, feedback);
		return ResponseEntity.ok(response);
	}
	
	//Fetching project employees
	@GetMapping("getProjectEmployees")
	public ResponseEntity<List<EmployeeResponse>> viewProjectEmployees(@RequestParam int projectid){
		List<EmployeeResponse> response = allotmentService.projectEmployeeList(projectid);
		return ResponseEntity.ok(response);
	}
}
