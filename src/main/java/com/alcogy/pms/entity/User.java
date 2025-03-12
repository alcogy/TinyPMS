package com.alcogy.pms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class User {
  @Id
  @Column
  @Getter
  @Setter
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  
  @Column(nullable = false)
  @Getter
  @Setter
  private String name;
  
  @Column(nullable = false)
  @Getter
  @Setter
  private String email;
}
