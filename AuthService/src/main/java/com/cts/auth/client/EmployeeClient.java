package com.cts.auth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.auth.dto.EmployeeDTO;


@FeignClient("EMPLOYEE-SERVICE")
public interface EmployeeClient {
	
	@PostMapping("employee/save")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employeeDTO);
	
}
