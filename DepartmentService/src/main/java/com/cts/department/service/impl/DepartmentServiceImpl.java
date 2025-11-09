package com.cts.department.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.department.entity.Department;
import com.cts.department.repository.DepartmentRepository;
import com.cts.department.service.DepartmentService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentRepository deptRepo;
	
	@Autowired
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.deptRepo = departmentRepository;
	}
	
	public void addDept(Department dept) {
		deptRepo.save(dept);
	}

	@Override
	public String updateDept(int id, Department dept) throws Exception {
		Department toUpdate = deptRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found"));
		toUpdate.setServiceline(dept.getServiceline());
		toUpdate.setVerticalline(dept.getVerticalline());
		
		deptRepo.save(toUpdate);
		return "Department Updated succesfully";
	}

	@Override
	public void deleteDept(int id) {
		deptRepo.deleteById(id);
	}

	@Override
	public List<Department> viewAllDept() {
		return deptRepo.findAll();
	}

}
