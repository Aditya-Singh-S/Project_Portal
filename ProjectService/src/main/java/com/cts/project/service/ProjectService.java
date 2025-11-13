package com.cts.project.service;

import java.util.List;

import com.cts.project.dto.ProjectDTO;
import com.cts.project.entity.Project;

public interface ProjectService {
	
	Project addProject(Project project);
	
	Project viewProject(int pid);
	
	Project updateProject(int pid, ProjectDTO projectDTO);
	
	String deleteProject(int id);
	
	List<Project> viewAllProject();
	
	
}
