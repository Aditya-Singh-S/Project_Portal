package com.cts.employee.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {

	private int empid;
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String designation;
	
	private int managerid;
	
	private String managername;
	
	private int deptid;
	
	private String deptname;
	
	private String contactno;
	
	private String location;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateofbirth;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate doj;
	
	private String resumepath;
	
	private boolean isactive;

}
