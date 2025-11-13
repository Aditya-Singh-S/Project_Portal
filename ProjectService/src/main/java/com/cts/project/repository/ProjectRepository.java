package com.cts.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.project.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
