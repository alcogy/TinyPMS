package com.alcogy.pms.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Project {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column
  @Getter
  @Setter
  private Integer id;

  @Column(nullable = false)
  @Getter
  @Setter
  private String title;
  
  @Column(nullable = false)
  @Getter
  @Setter
  @Lob
  private String content;

  @Getter
  @Setter
  @ManyToOne
  @JoinColumn(name = "phaseId", nullable = false)
  private Phase phase;

  @Getter
  @Setter
  @ManyToOne
  @JoinColumn(name = "userId", nullable = false)
  private User user;

  @Column(nullable = false)
  @Getter
  @Setter
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;
}
