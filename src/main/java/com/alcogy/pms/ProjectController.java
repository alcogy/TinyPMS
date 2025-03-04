package com.alcogy.pms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

@Controller
@RequestMapping(path="/project")
public class ProjectController {
  @Autowired
  private ProjectRepository projectRepository;

  @GetMapping(path="/")
  public @ResponseBody Iterable<Project> getAllProjects() {
    return projectRepository.findAll();
  }

  @GetMapping(path="/{id}")
  public @ResponseBody Optional<Project> getProjectById(@PathVariable(value="id") final String id) {
    return projectRepository.findById(Integer.parseInt(id));
  }

}
