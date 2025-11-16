package com.cts.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.project.dto.ProjectDTO;
import com.cts.project.entity.Project;
import com.cts.project.repository.ProjectRepository;
import com.cts.project.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	private ProjectRepository projectRepo;
	
	@Autowired
	public ProjectServiceImpl(ProjectRepository projectRepo) {
		this.projectRepo = projectRepo;
	}
	
	@Override
	public Project addProject(Project project) {
		return projectRepo.save(project);
	}

	@Override
	public Project viewProject(int pid) {
		return projectRepo.findById(pid).orElseThrow(() -> new RuntimeException("Project Not Found"));
	}

	@Override
	public Project updateProject(int pid, ProjectDTO dto) {
		
		Project toUpdate = projectRepo.findById(pid).get();
		
		toUpdate.setPdescription(dto.getPdescription());
		toUpdate.setEnddate(dto.getEnddate());
		toUpdate.setPname(dto.getPname());
		toUpdate.setSkillrequired(dto.getSkillrequired());
		toUpdate.setTeamsize(dto.getTeamsize());
		
		projectRepo.save(toUpdate);
		
		return toUpdate;
	}

	@Override
	public String deleteProject(int pid) {
		projectRepo.deleteById(pid);
		return "Project Deleted";
	}
	
	public List<Project> viewAllProject(){
		return projectRepo.findAll();
	}

	@Override
	public List<Project> getDeptProjects(int deptid) {
		return projectRepo.findByDeptid(deptid);
	}

}
