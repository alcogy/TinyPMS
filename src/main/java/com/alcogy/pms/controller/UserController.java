package com.alcogy.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alcogy.pms.repository.UserRepository;
import com.alcogy.pms.model.User;


@Controller
@RequestMapping(path="/user")
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }

  @PostMapping(path="/add")
  public @ResponseBody String addUser(@RequestParam String name, @RequestParam String email) {
    User u = new User();
    u.setName(name);
    u.setEmail(email);
    userRepository.save(u);

    return "saved";
  }

}
