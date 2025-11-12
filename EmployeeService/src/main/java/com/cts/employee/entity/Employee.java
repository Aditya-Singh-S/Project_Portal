package com.cts.employee.entity;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@Column
	private int empid;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private String email;
	
	@Column
	private String designation;
	
	@Column
	private int managerid;
	
	@Column
	private int deptid;
	
	@Column
	private String contactno;
	
	@Column
	private String location;
	
	@Column
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateofbirth;
	
	@Column
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate doj;
	
	@Column
	private String resumepath;
	
	@Column
	private boolean isactive;
	
}
