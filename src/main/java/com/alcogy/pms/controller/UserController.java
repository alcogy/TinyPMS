package com.alcogy.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.alcogy.pms.repository.UserRepository;
import com.alcogy.pms.entity.User;
import com.alcogy.pms.model.Login;

@Controller
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping(path="/users")
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }

  // Login View
  @GetMapping("/login")
  public ModelAndView login(ModelAndView mav) {
    mav.setViewName("login");
    return mav;
  }

  // Login
  @PostMapping("/login")
  public String login(@ModelAttribute("formModel") Login login) {
    System.out.println(login.getEmail());
    // TODO Authorization;
    return "redirect:/projects";
  }

  // Logout

}
