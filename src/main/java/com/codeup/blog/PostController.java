package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String index() {
        return "index of blog posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId(@PathVariable int id) {
        return "viewing post #" + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "create post form";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postedPost() {
        return "postedPost works";
    }

}