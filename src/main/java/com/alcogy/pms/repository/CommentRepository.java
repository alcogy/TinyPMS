package com.alcogy.pms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.alcogy.pms.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
  
  List<Comment> findByProjectIdOrderByCreatedDateDesc(Integer projectId);
  
} 
