package com.cts.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.application.entity.ProjectAllotment;

@Repository
public interface ProjectAllotmentRepository extends JpaRepository<ProjectAllotment, Integer> {
	
	@Query(value = "SELECT empid FROM PROJECTALLOTMENT WHERE projectid = :projectid", nativeQuery = true)
	List<Integer> getProjectEmployeesId(int projectid);
}
