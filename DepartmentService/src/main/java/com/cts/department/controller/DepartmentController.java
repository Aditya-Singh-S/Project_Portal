package com.cts.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.department.entity.Department;
import com.cts.department.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	private DepartmentService deptService;
	
	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		this.deptService = departmentService;
	}
	
	@PostMapping
	public String addDept(@RequestBody Department dept) {
		deptService.addDept(dept);
		return "Department added Succesfully";
	}
	
	@PutMapping("/{id}")
	public String updateDept(@PathVariable int id, @RequestBody Department dept) throws Exception {
		deptService.updateDept(id, dept);
		return "Department updated succesfully";
	}
	
	@DeleteMapping("/{id}")
	public String deleteDept(@PathVariable int id) {
		deptService.deleteDept(id);
		return "Department deleted succesfully";
	}
	
	@GetMapping
	public List<Department> viewAllDept(){
		return deptService.viewAllDept();
	}
}
