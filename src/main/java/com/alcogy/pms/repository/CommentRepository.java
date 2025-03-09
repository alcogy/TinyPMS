package com.alcogy.pms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alcogy.pms.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
  
  List<Comment> findByProjectIdOrderByCreatedDateDesc(Integer projectId);
  
} 
