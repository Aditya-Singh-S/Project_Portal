package com.cts.application.entity;

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
public class ProjectAllotment {
	
	@Id
	private int applicationid;
	
	@Column
	private int projectid;
	
	@Column
	private int empid;
	
	@Column
	private String status;
	
	@Column
	private String feedback;
}
