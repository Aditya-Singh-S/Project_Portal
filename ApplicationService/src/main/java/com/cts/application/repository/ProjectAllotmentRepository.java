package com.cts.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.application.entity.ProjectAllotment;

@Repository
public interface ProjectAllotmentRepository extends JpaRepository<ProjectAllotment, Integer> {

}
