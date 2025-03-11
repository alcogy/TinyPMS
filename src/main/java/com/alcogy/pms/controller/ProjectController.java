package com.alcogy.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.alcogy.pms.entity.Comment;
import com.alcogy.pms.entity.Phase;
import com.alcogy.pms.entity.Project;
import com.alcogy.pms.entity.User;
import com.alcogy.pms.model.PostComment;
import com.alcogy.pms.model.PostProject;
import com.alcogy.pms.repository.CommentRepository;
import com.alcogy.pms.repository.PhaseRepository;
import com.alcogy.pms.repository.ProjectRepository;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;

@Controller
public class ProjectController {
  @Autowired
  private ProjectRepository projectRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private PhaseRepository phaseRepository;

  @GetMapping("/projects")
  public ModelAndView list(ModelAndView mav, HttpSession session) {
    User loginUser = (User) session.getAttribute("user");
    if (loginUser == null) return new ModelAndView("redirect:/login");
    mav.addObject("userName", loginUser.getName());

    mav.addObject("projects", projectRepository.findAll());
    mav.setViewName("list");    
    return mav;
  }
  
  @GetMapping(path="/project/{id}")
  public ModelAndView detail(@PathVariable(value="id") final String pid, ModelAndView mav, HttpSession session) {
    User loginUser = (User) session.getAttribute("user");
    if (loginUser == null) return new ModelAndView("redirect:/login");
    mav.addObject("userName", loginUser.getName());

    Integer id = Integer.parseInt(pid);
    Optional<Project> project = projectRepository.findById(id);
    if (!project.isPresent()) {
      mav.setViewName("redirect:/projects");
      return mav;
    }

    mav.addObject("project", project.get());
    mav.addObject("comments", commentRepository.findByProjectIdOrderByCreatedDateDesc(id));
    mav.setViewName("detail");
    return mav;
  }

  @GetMapping("/project/create")
  public ModelAndView register(ModelAndView mav, HttpSession session) {
    User loginUser = (User) session.getAttribute("user");
    if (loginUser == null) return new ModelAndView("redirect:/login");
    mav.addObject("userName", loginUser.getName());

    List<Phase> phases = phaseRepository.findAll();
    mav.addObject("phases", phases);
    mav.addObject("project", new Project());
    mav.addObject("action", "/project/create");
    mav.addObject("title", "Create Project");
    mav.setViewName("edit");
    return mav;
  }
  
  @GetMapping("/project/edit/{id}")
  public ModelAndView edit(@PathVariable(value="id") final String id, ModelAndView mav, HttpSession session) {
    User loginUser = (User) session.getAttribute("user");
    if (loginUser == null) return new ModelAndView("redirect:/login");
    mav.addObject("userName", loginUser.getName());

    Optional<Project> project = projectRepository.findById(Integer.parseInt(id));
    List<Phase> phases = phaseRepository.findAll();
    mav.addObject("phases", phases);
    mav.addObject("project", project.get());
    mav.addObject("action", "/project/edit/" + id);
    mav.addObject("title", "Edit Project");
    mav.setViewName("edit");
    return mav;
  }

  @PostMapping("/project/create")
  public String create(@ModelAttribute("formModel") PostProject post, HttpSession session) {
    User loginUser = (User) session.getAttribute("user");
    if (loginUser == null) return "redirect:/login";

    projectRepository.saveAndFlush(post.convertProject());
    return "redirect:/projects";
  }

  @PostMapping("/project/edit/{id}")
  public String edit(
    @PathVariable(value="id") final String id,
    @ModelAttribute("formModel") PostProject post,
    HttpSession session
  ) {
    User loginUser = (User) session.getAttribute("user");
    if (loginUser == null) return "redirect:/login";

    projectRepository.saveAndFlush(post.convertProject());
    return "redirect:/projects";
  }

  @PostMapping("/project/comment")
  public String postComment(@ModelAttribute("formModel") PostComment postComment, HttpSession session) {
    User loginUser = (User) session.getAttribute("user");
    if (loginUser == null) return "redirect:/login";

    Comment comment = postComment.convertComment(1);
    commentRepository.saveAndFlush(comment);
    return "redirect:/project/" + postComment.getProjectId();
  }
  
}
