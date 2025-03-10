package com.alcogy.pms.model;

import java.util.Date;

import com.alcogy.pms.entity.Comment;
import com.alcogy.pms.entity.Project;
import com.alcogy.pms.entity.User;

import lombok.Getter;
import lombok.Setter;

public class PostComment {
  @Getter
  @Setter
  private String comment;

  @Getter
  @Setter
  private String projectId;

  public Comment convertComment(Integer userId) {
    Comment com = new Comment();
    com.setComment(comment);
    com.setCreatedDate(new Date());

    Project project = new Project();
    project.setId(Integer.parseInt(projectId));
    com.setProject(project);

    User user = new User();
    user.setId(userId);
    com.setUser(user);

    return com;
  }
}
