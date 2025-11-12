package com.cts.employee.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Component
@Data
public class HRUpdateDTO {
	private int deptid;
	private int managerid;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate doj;
	
	private String location;
}
