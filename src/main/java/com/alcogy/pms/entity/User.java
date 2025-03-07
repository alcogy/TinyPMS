package com.alcogy.pms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class User {
  @Id
  @Getter
  @Setter
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  
  @Getter
  @Setter
  private String name;
  
  @Getter
  @Setter
  private String email;
}
