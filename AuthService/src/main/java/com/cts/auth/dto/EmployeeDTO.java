package com.cts.auth.dto;

import com.cts.auth.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class EmployeeDTO {
	
	private int empid;
	private String email;
	private boolean isactive;
	
	@Column
	@Enumerated(EnumType.STRING)
	private UserRole role;

}
