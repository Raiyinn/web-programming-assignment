package com.packt.webinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.webinfo.dao.NewsDao;
import com.packt.webinfo.service.NewsService;

@Controller
public class HomeController {
	@Autowired
	private NewsService newsService;
  @RequestMapping("/")
  public String welcome(Model model) {
    model.addAttribute("greeting", "Welcome to the WebInfo Portal!");
    model.addAttribute("tagline", "Read all about the current news and events!");
    model.addAttribute("news", newsService.getNewNews());
    return "welcome";
  }
  
  @RequestMapping("/welcome/greeting")
  public String greeting() {
   return "welcome";
  }
  
} 
