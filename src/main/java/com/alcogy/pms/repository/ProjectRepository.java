package com.alcogy.pms.repository;

import org.springframework.data.repository.CrudRepository;
import com.alcogy.pms.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
} 
