package com.cts.employee.dto;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Component
@Data
public class EmployeeDTO {
	
	private int empid;
	private String email;
	private boolean isactive;
	private String role;
	
}
