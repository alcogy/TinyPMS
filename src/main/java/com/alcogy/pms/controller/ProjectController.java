package com.alcogy.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import com.alcogy.pms.model.Project;
import com.alcogy.pms.repository.ProjectRepository;
import java.util.Optional;

@Controller
public class ProjectController {
  @Autowired
  private ProjectRepository projectRepository;

  @GetMapping("/projects")
  public String list(Model model) {
    return "list";
  }
  
  @GetMapping(path="/project/{id}")
  public String detail(@PathVariable(value="id") final String id, Model model) {
    // Optional<Project> project = projectRepository.findById(Integer.parseInt(id));
    return "detail";
  }

  @GetMapping("/project/create/")
  public String create(Model model) {
    return "edit";
  }
  
}
