package com.alcogy.pms;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  private String title;
  
  @Lob
  private String absolute;
  private Integer phase;
  private Integer representative;
  
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAbsolute() {
    return absolute;
  }

  public void setAbsolute(String absolute) {
    this.absolute = absolute;
  }

  public Integer getPhase() {
    return phase;
  }

  public void setPhase(Integer phase) {
    this.phase = phase;
  }

  public Integer getRepresentative() {
    return representative;
  }

  public void setRepresentative(Integer representative) {
    this.representative = representative;
  }
}
