package com.cts.project.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	@Column
	private int deptid;
	
	@Column
	private int pmgrid;
	
	@Column
	private String pname;
	
	@Column
	private String pdescription;
	
	@Column
	private String parent;
	
	@Column
	private String skillrequired;
	
	@Column
	private int teamsize;
	
	@Column
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startdate;
	
	@Column
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate enddate;
	
	
	
}
