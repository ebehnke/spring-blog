package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.repositories.UserRepository;
import com.codeup.blog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Time;
import java.util.Date;

@Controller
public class HomeController {

    private final PostRepository postsRepo;
    private final UserRepository usersRepo;
//    private EmailService emailService;

    public HomeController(PostRepository postsRepo, UserRepository usersRepo) {
        this.postsRepo = postsRepo;
        this.usersRepo = usersRepo;
    }

    @GetMapping("/")
    public String welcome() {
        return "home";
    }

    @GetMapping("/home/{name}")
    public String welcome(@PathVariable String name, Model viewModel) {
        viewModel.addAttribute("name", name);
        return "home";
    }

    @GetMapping("/home")
    public String welcome2(Model model) {
        model.addAttribute("datetime", new Post());
        return "home";
    }

    @PostMapping("/home")
    public String datepicker(@ModelAttribute Post postToSaved){
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDB = usersRepo.findOne(sessionUser.getId());
        postToSaved.setAuthor(userDB);
        Post savedPost = postsRepo.save(postToSaved);




//        model.addAttribute("datepicker1", datepicker1);
//        model.addAttribute("timepicker1", timepicker1);
//        model.addAttribute("datepicker2", datepicker2);
//        model.addAttribute("timepicker2", timepicker2);
//        System.out.println("" + datepicker1 + timepicker1 + datepicker2 + timepicker2);
//        return "home";
        return "redirect:/posts/" + savedPost.getId();

    }
}
