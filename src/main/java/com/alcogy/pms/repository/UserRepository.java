package com.alcogy.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alcogy.pms.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {  
} 
