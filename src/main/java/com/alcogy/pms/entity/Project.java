package com.alcogy.pms.entity;

import java.util.Date;

import jakarta.persistence.*;
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
  @ManyToOne
  @JoinColumn(name = "phaseId")
  private Phase phase;

  @Getter
  @Setter
  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;

  @Getter
  @Setter
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;
}
