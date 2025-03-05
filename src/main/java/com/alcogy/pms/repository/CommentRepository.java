package com.alcogy.pms.repository;

import org.springframework.data.repository.CrudRepository;
import com.alcogy.pms.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
} 
