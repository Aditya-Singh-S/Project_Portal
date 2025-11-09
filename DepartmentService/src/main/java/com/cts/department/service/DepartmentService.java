package com.cts.department.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.department.entity.Department;

public interface DepartmentService {
	
	public void addDept(Department dept);
	
	public String updateDept(int id, Department dept) throws Exception;
	
	public void deleteDept(int id);
	
	public List<Department> viewAllDept();
}
