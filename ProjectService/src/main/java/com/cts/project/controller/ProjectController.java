package com.cts.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.dto.ProjectDTO;
import com.cts.project.entity.Project;
import com.cts.project.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	private ProjectService projectService;
	
	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Project> addProject(@RequestBody Project project){
		Project response = projectService.addProject(project);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{pid}")
	public ResponseEntity<Project> viewProject(@PathVariable("pid") int pid){
		Project response = projectService.viewProject(pid);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{pid}")
	public ResponseEntity<Project> updateProject(@PathVariable("pid") int pid,@RequestBody ProjectDTO projectDto){
		Project response = projectService.updateProject(pid, projectDto);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{pid}")
	public ResponseEntity<String> deleteProject(@PathVariable("pid") int pid){
		String response = projectService.deleteProject(pid);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<Project>> viewAllProjects(){
		List<Project> response = projectService.viewAllProject();
		return ResponseEntity.ok(response);
	}
	
	
	//Department -> Project WorkFlow
	@GetMapping("/getProjects")
	public ResponseEntity<List<Project>> getEmployees(@RequestParam int deptid){
		List<Project> deptProjects = projectService.getDeptProjects(deptid);
		return ResponseEntity.ok(deptProjects);
	}
}
