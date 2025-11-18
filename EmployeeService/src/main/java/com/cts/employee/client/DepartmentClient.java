package com.cts.employee.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.employee.dto.Department;


@FeignClient("DEPARTMENT-SERVICE")
public interface DepartmentClient {
	
	@GetMapping("department/{id}")
	public ResponseEntity<Department> viewById(@PathVariable("id") int deptid);
	
}
