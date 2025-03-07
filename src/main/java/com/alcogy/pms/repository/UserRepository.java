package com.alcogy.pms.repository;

import org.springframework.data.repository.CrudRepository;
import com.alcogy.pms.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {  
} 
