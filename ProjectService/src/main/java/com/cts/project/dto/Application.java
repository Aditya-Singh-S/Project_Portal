package com.cts.project.dto;


import lombok.Data;

@Data
public class Application {
	
	private int applicationid;
	
	private int projectid;
	
	private int empid;
	
	private String status = "WAITING";
}
