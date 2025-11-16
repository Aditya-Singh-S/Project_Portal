package com.cts.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
}
