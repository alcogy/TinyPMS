package com.alcogy.pms;

import org.springframework.data.repository.CrudRepository;
import com.alcogy.pms.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
} 
