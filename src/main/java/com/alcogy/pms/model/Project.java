package com.alcogy.pms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Project {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Getter
  @Setter
  private Integer id;

  @Getter
  @Setter
  private String title;
  
  @Getter
  @Setter
  @Lob
  private String content;

  @Getter
  @Setter
  private Integer phase;

  @Getter
  @Setter
  private Integer representative;
  
}
