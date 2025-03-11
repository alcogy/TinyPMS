package com.alcogy.pms.controller;

import java.util.Optional;

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
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
  @Autowired
  private UserRepository userRepository;

  // Login View
  @GetMapping("/")
  public String index(HttpSession session) {
    User loginUser = (User) session.getAttribute("user");
    if (loginUser == null) {
      return "redirect:/login";
    }

    return "redirect:/projects";
  }

  // Login View
  @GetMapping("/login")
  public ModelAndView login(ModelAndView mav) {
    mav.setViewName("login");
    return mav;
  }

  // Login
  @PostMapping("/login")
  public String login(@ModelAttribute("formModel") Login login, HttpSession session) {
    Optional<User> user = userRepository.findByEmail(login.getEmail());
    if (!user.isPresent()) return "redirect:/login?error";   
    
    session.setAttribute("user", user.get());
    return "redirect:/projects";
  }

  // Logout
  @PostMapping("/logout")
  public String logout(HttpSession session) {
    session.removeAttribute("user");
    return "redirect:/login";
  }
}
