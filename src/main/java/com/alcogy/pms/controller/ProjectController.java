package com.alcogy.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

import com.alcogy.pms.entity.Project;
import com.alcogy.pms.model.PostProject;
import com.alcogy.pms.repository.CommentRepository;
import com.alcogy.pms.repository.ProjectRepository;
import java.util.Optional;

@Controller
public class ProjectController {
  @Autowired
  private ProjectRepository projectRepository;

  @Autowired
  private CommentRepository commentRepository;

  @GetMapping("/projects")
  public String list(Model model) {
    model.addAttribute("projects", projectRepository.findAll());

    return "list";
  }
  
  @GetMapping(path="/project/{id}")
  public String detail(@PathVariable(value="id") final String pid, Model model) {
    Integer id = Integer.parseInt(pid);
    Optional<Project> project = projectRepository.findById(id);
    if (!project.isPresent()) {
      return "redirect:/projects";
    }
    model.addAttribute("project", project.get());
    model.addAttribute("comments", commentRepository.findByProjectIdOrderByCreatedDateDesc(id));
    return "detail";
  }

  @GetMapping("/project/create")
  public String register(Model model) {
    return "edit";
  }
  
  @GetMapping("/project/edit/{id}")
  public String edit(@PathVariable(value="id") final String id, Model model) {
    return "edit";
  }

  @PostMapping("project/create")
  public String create(@ModelAttribute PostProject post, Model model) {
    return "redirect:/projects";
  }
  
}
