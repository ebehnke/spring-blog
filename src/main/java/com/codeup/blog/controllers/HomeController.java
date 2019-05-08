package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/")
    public String welcome2() {
        return "home";
    }
    @GetMapping("/home")
    public String welcome() {
        return "home";
    }

    @GetMapping("/home/{name}")
    public String welcome(@PathVariable String name, Model viewModel) {
        viewModel.addAttribute("name", name);
        return "home";
    }
}
