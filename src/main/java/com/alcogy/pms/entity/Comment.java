package com.alcogy.pms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Temporal;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
public class Comment {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column
  @Getter
  @Setter
  private Integer id;

  @Getter
  @Setter
  @Column(nullable = false)
  private String comment;

  @Getter
  @Setter
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date createdDate;
    
  @Getter
  @Setter
  @ManyToOne
  @JoinColumn(name = "projectId", nullable = false)
  private Project project;

  @Getter
  @Setter
  @ManyToOne
  @JoinColumn(name = "userId", nullable = false)
  private User user;
}