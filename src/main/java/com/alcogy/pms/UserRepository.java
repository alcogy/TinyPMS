package com.alcogy.pms;

import org.springframework.data.repository.CrudRepository;
import com.alcogy.pms.User;

public interface UserRepository extends CrudRepository<User, Integer> {  
} 
