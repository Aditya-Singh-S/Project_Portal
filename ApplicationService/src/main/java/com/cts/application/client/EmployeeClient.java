package com.cts.application.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.application.dto.EmployeeResponse;


@FeignClient("EMPLOYEE-SERVICE")
public interface EmployeeClient {
	
	@GetMapping("employee/{empid}")
	public ResponseEntity<EmployeeResponse> viewEmployeeDetails(@PathVariable("empid") int id);
}
