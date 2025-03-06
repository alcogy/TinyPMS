package com.alcogy.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import com.alcogy.pms.repository.UserRepository;
import com.alcogy.pms.model.User;
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
  public String login(Model model) {
    return "login";
  }

  // Login
  @PostMapping("/login")
  public String login(@ModelAttribute Login login, Model model) {
    System.out.println(login.getEmail());
    // TODO Authorization;
    return "redirect:/users";
  }

  // Logout

}
