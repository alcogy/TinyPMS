package com.alcogy.pms.model;

import java.util.Date;

import com.alcogy.pms.entity.Phase;
import com.alcogy.pms.entity.Project;
import com.alcogy.pms.entity.User;

import lombok.Getter;
import lombok.Setter;

public class PostProject {
  @Getter
  @Setter
  private String title;
  
  @Getter
  @Setter
  private String content;

  public Project convertProject() {
    Project project = new Project();
    project.setTitle(title);
    project.setContent(content);
    project.setCreatedDate(new Date());

    Phase phase = new Phase();
    phase.setId(1);
    project.setPhase(phase);

    User user = new User();
    user.setId(1);
    project.setUser(user);

    return project;
  }
}
