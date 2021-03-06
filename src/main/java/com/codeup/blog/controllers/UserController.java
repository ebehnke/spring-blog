package com.codeup.blog.controllers;

import com.codeup.blog.models.User;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserRepository usersRepo;
    private PasswordEncoder passwordEncoder;


    public UserController(UserRepository usersRepo, PasswordEncoder passwordEncoder) {
        this.usersRepo = usersRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersRepo.save(user);
        return "redirect:/login";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", usersRepo.findAll());
        return "/users/index";
    }

    @GetMapping("users/{id}")
    public String showUser(@PathVariable Long id, Model model){
        User user = usersRepo.findOne(id);
        model.addAttribute("user", user);
        return "/users/show";
    }

//    @GetMapping("/users/create")
//    public String showCreateUser(Model model) {
//        model.addAttribute("user", new User());
//        return "/users/create";
//    }
//
//    @PostMapping("/users/create")
//    public String createPost(@ModelAttribute User user) {
//        usersRepo.save(user);
//        return "redirect:/users";
//    }

//    @GetMapping("/users/{id}/edit")
//    public String showEditUser(@PathVariable Long id, Model model) {
//        User user = usersRepo.findOne(id);
//        model.addAttribute("user", user);
//        return "/users/edit";
//    }
//
//    @PostMapping("/users/{id}/edit")
//    public String editUser(@PathVariable Long id, @RequestParam String username, @RequestParam String password, @RequestParam String email) {
//        User user = usersRepo.findOne(id);
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setEmail(email);
//        usersRepo.save(user);
//        return "redirect:/users";
//    }

//    @GetMapping("/users/{id}/delete")
//    public String deleteUser(@PathVariable Long id) {
//        usersRepo.delete(usersRepo.findOne(id));
//        return "redirect:/users";
//    }

}