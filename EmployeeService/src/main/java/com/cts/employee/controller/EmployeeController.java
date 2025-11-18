package com.cts.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.employee.dto.EmpUpdateDTO;
import com.cts.employee.dto.EmployeeDTO;
import com.cts.employee.dto.EmployeeResponse;
import com.cts.employee.dto.HRUpdateDTO;
import com.cts.employee.entity.Employee;
import com.cts.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employeeDTO){
		Employee employee = employeeService.addEmployee(employeeDTO);
		return ResponseEntity.ok("Employee created");
	}
	
	@GetMapping("/{empid}")
	public ResponseEntity<EmployeeResponse> viewEmployeeDetails(@PathVariable("empid") int id){
		EmployeeResponse emp = employeeService.viewEmployeeDetails(id);
		return ResponseEntity.ok(emp);
	}
	
	@PutMapping("/{empid}")
	public ResponseEntity<Employee> updateEmployeeDetails(@PathVariable("empid") int id, @RequestBody EmpUpdateDTO requestDto ){
		Employee emp = employeeService.updateEmployee(id, requestDto);
		return ResponseEntity.ok(emp);
	}
	
	@PutMapping("/hr/{empid}")
	public ResponseEntity<Employee> hrUpdateEmployeeDetails(@PathVariable("empid") int id, @RequestBody HRUpdateDTO requestDto ){
		Employee emp = employeeService.hrUpdateEmployee(id, requestDto);
		return ResponseEntity.ok(emp);
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<EmployeeResponse>> viewAllEmployee(){
		List<EmployeeResponse> employees = employeeService.viewAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	//Department -> Employee WorkFlow
	@GetMapping("/getEmployees")
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam int deptid){
		List<Employee> deptEmployees = employeeService.getDeptEmployees(deptid);
		return ResponseEntity.ok(deptEmployees);
	}
}
