package com.cts.department.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Project {
	
	private int pid;
	
	private int deptid;
	
	private int pmgrid;
	
	private String pname;
	
	private String pdescription;
	
	private String parent;
	
	private String skillrequired;
	
	private int teamsize;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startdate;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate enddate;
}
