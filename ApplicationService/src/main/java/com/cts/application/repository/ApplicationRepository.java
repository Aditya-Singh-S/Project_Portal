package com.cts.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.application.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}
