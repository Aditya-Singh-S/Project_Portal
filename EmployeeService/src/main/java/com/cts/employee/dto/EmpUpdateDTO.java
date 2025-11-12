package com.cts.employee.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Component
@Data
public class EmpUpdateDTO {
	
	private String firstname;
	private String lastname;
	private String contactno;
	private String resumepath;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateofbirth;
	
}
