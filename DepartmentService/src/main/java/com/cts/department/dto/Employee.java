package com.cts.department.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Employee {
	
	private int empid;
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String designation;
	
	private int deptid;
	
	private int managerid;
	
	private String contactno;
	
	private String location;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateofbirth;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate doj;
	
	private String resumepath;
	
	private boolean isactive;
}
