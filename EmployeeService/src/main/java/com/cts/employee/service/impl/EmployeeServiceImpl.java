package com.cts.employee.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.employee.dto.EmpUpdateDTO;
import com.cts.employee.dto.EmployeeDTO;
import com.cts.employee.dto.HRUpdateDTO;
import com.cts.employee.entity.Employee;
import com.cts.employee.repository.EmployeeRepository;
import com.cts.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepo = employeeRepository;
	}

	@Override
	public Employee addEmployee(EmployeeDTO dto) {
		Employee employee = new Employee();
		employee.setEmpid(dto.getEmpid());
		employee.setEmail(dto.getEmail());
		employee.setIsactive(dto.isIsactive());
		employee.setDesignation(dto.getRole());
		
		employeeRepo.save(employee);
		
		return employee;
	}

	@Override
	public Employee viewEmployeeDetails(int id) {
		return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee Not found"));
	}

	@Override
	public Employee updateEmployee(int id, EmpUpdateDTO dto) {
		
		Employee emp = employeeRepo.findById(id).get();
		
		emp.setFirstname(dto.getFirstname());
		emp.setLastname(dto.getLastname());
		emp.setContactno(dto.getContactno());
		emp.setResumepath(dto.getResumepath());
		emp.setDateofbirth(dto.getDateofbirth());
		
		employeeRepo.save(emp);
		return emp;
	}

	@Override
	public List<Employee> viewAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee hrUpdateEmployee(int id, HRUpdateDTO dto) {
		Employee emp = employeeRepo.findById(id).get();
		
		emp.setDeptid(dto.getDeptid());
		emp.setManagerid(dto.getManagerid());
		emp.setLocation(dto.getLocation());
		emp.setDoj(dto.getDoj());
		
		employeeRepo.save(emp);
		
		return emp;
	}

	@Override
	public List<Employee> getDeptEmployees(int deptid) {
		List<Employee> emp = employeeRepo.findByDeptid(deptid);
		return emp;
	}


}
