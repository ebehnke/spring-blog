//package com.codeup.blog.controllers;
//
//import com.codeup.blog.models.User;
//import com.codeup.blog.repositories.UserRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.context.annotation.SessionScope;
//
//@Controller
//public class UserController {
//
//    private final UserRepository userRepo;
//
//    public UserController(UserRepository userRepo) {
//        this.userRepo = userRepo;
//    }
//
//    @GetMapping("/user")
//    public String hello() {
//        return "Hello from Spring!";
//    }
//
//    @GetMapping("")
//    public String testUser(){
//
//        User created = new User("created", "password", "created@email.com");
//        userRepo.save(created);
//        return "";
//    }
//}