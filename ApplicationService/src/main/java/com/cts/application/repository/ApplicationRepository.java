package com.cts.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.application.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
	
	List<Application> findByProjectid(int projectid);
}
