package com.alcogy.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@SpringBootApplication
public class PmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(PmsApplication.class, args);
	}

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("message", "Hello my world!!");
    return "index";
  }
}
