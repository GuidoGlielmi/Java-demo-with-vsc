package com.example.springdemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  // inject via application.properties
  //@Value("${welcome.message}")
  private String message = "Hello World";

  @RequestMapping("/")
  public String index(Model model) { // model is the global object of the JSP
    model.addAttribute("greeting", message);
    return "index"; //JSP name
  }
}