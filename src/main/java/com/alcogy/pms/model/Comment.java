package com.alcogy.pms.model;

import jakarta.persistence.Entity;
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
  @Getter
  @Setter
  private Integer id;

  @Getter
  @Setter
  private String comment;

  @Getter
  @Setter
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;
    
  @Getter
  @Setter
  @ManyToOne
  @JoinColumn(name = "projectId")
  private Project project;

  @Getter
  @Setter
  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;
}