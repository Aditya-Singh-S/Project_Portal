package com.cts.employee.service;

import java.util.List;

import com.cts.employee.dto.EmpUpdateDTO;
import com.cts.employee.dto.EmployeeDTO;
import com.cts.employee.dto.EmployeeResponse;
import com.cts.employee.dto.HRUpdateDTO;
import com.cts.employee.entity.Employee;

public interface EmployeeService {
	Employee addEmployee(EmployeeDTO employeeDTO);
	
	EmployeeResponse viewEmployeeDetails(int id);
	
	Employee updateEmployee(int id, EmpUpdateDTO empUpdateDTO);
	
	Employee hrUpdateEmployee(int id, HRUpdateDTO hrUpdateDTO);
	
	List<EmployeeResponse> viewAllEmployees();

	List<Employee> getDeptEmployees(int deptid);
}
