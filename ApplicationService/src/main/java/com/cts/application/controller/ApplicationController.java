package com.cts.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.application.entity.Application;
import com.cts.application.service.ApplicationService;

@RestController
@RequestMapping("/application")
public class ApplicationController {
	
	private ApplicationService applicationService;
	
	@Autowired
	public ApplicationController(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}
	
	@PostMapping
	public ResponseEntity<Application> addApplication(@RequestBody Application application){
		Application response = applicationService.addApplication(application);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}/approve")
	public ResponseEntity<String> approveApplication(@PathVariable("id") int id){
		String response = applicationService.approveApplication(id);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}/deny")
	public ResponseEntity<String> denyApplication(@PathVariable("id") int id){
		String response = applicationService.denyApplication(id);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<Application>> viewAllApplication(){
		List<Application> response = applicationService.viewAllApplication();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Application> viewApplication(@PathVariable("id") int id){
		Application response = applicationService.viewApplication(id);
		return ResponseEntity.ok(response);
	}
}
