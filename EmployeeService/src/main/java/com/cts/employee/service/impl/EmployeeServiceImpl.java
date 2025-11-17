package com.cts.employee.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.employee.client.DepartmentClient;
import com.cts.employee.dto.Department;
import com.cts.employee.dto.EmpUpdateDTO;
import com.cts.employee.dto.EmployeeDTO;
import com.cts.employee.dto.EmployeeResponse;
import com.cts.employee.dto.HRUpdateDTO;
import com.cts.employee.entity.Employee;
import com.cts.employee.repository.EmployeeRepository;
import com.cts.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private DepartmentClient deptClient;
	
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
		
		employee.setDeptid(1); //Default to department 1
		employee.setManagerid(1); // Default HR as initial manager
		
		employeeRepo.save(employee);
		
		return employee;
	}

	@Override
	public EmployeeResponse viewEmployeeDetails(int id) {
		Employee emp = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee Not found"));
		
		EmployeeResponse empResponse = new EmployeeResponse(emp.getEmpid(), emp.getFirstname(), emp.getLastname(), 
				emp.getEmail(), emp.getDesignation(), emp.getManagerid(), null, emp.getDeptid(), null, emp.getContactno(), 
				emp.getLocation(), emp.getDateofbirth(), emp.getDoj(), emp.getResumepath(), emp.isIsactive());
		
		Employee manager = employeeRepo.findById(emp.getManagerid()).orElseThrow(() -> new RuntimeException("Manager Not found"));
		empResponse.setManagername(manager.getFirstname()+" "+manager.getLastname());
		
		Department dept = deptClient.viewById(emp.getDeptid()).getBody();
		empResponse.setDeptname(dept.getDeptname());
		
		return empResponse;
		
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
	public List<EmployeeResponse> viewAllEmployees() {
		
		List<Employee> empList = employeeRepo.findAll();
		
		List<EmployeeResponse> responseList = new ArrayList<>();
		
		for(Employee emp : empList) {
			EmployeeResponse empResponse = new EmployeeResponse(emp.getEmpid(), emp.getFirstname(), emp.getLastname(), 
					emp.getEmail(), emp.getDesignation(), emp.getManagerid(), null, emp.getDeptid(), null, emp.getContactno(), 
					emp.getLocation(), emp.getDateofbirth(), emp.getDoj(), emp.getResumepath(), emp.isIsactive());
			
//			Employee manager = employeeRepo.findById(emp.getManagerid()).orElseThrow(() -> new RuntimeException("Manager Not found"));
			
			Employee manager = employeeRepo.findById(emp.getManagerid()).orElse(null);
			empResponse.setManagername(manager.getFirstname()+" "+manager.getLastname());
			
			Department dept = deptClient.viewById(emp.getDeptid()).getBody();
			empResponse.setDeptname(dept.getDeptname());
			
			responseList.add(empResponse);
		}
		
		return responseList;
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
		List<Employee> empList = employeeRepo.findByDeptid(deptid);
		return empList;
	}


}
