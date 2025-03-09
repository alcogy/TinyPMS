package com.alcogy.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alcogy.pms.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
} 
