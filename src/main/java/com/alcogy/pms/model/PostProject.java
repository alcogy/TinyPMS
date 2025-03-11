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
  private String id; 

  @Getter
  @Setter
  private String title;
  
  @Getter
  @Setter
  private String content;

  @Getter
  @Setter
  private String phaseId;

  public Project convertProject(Integer userId) {
    Project project = new Project();
    project.setTitle(title);
    project.setContent(content);
    project.setCreatedDate(new Date());
    if (id != null && id != "") {
      project.setId(Integer.parseInt(id));
    }

    Phase phase = new Phase();
    phase.setId(Integer.parseInt(phaseId));
    project.setPhase(phase);

    User user = new User();
    user.setId(userId);
    project.setUser(user);

    return project;
  }
}
