package com.alcogy.pms.repository;

import org.springframework.data.repository.CrudRepository;
import com.alcogy.pms.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
} 
