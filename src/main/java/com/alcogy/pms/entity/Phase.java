package com.alcogy.pms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Phase {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Getter
  @Setter
  private Integer id;

  @Getter
  @Setter
  private String label;
}