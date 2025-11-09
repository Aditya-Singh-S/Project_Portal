package com.cts.department.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptid;
	
	@Column
	private String serviceline;
	
	@Column
	private String verticalline;
	
}
