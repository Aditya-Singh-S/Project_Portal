package com.cts.project.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Component
@Data
public class ProjectDTO {
	
	private String pname;
	
	private String pdescription;
	
	private String skillrequired;
	
	private int teamsize;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate enddate;
}
