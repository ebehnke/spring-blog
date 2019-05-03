package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    List<Post> posts = new ArrayList<>();

    @GetMapping("/posts")
    public String viewPosts(Model model) {

//        Post postsTest = new Post("postTest title", "postsTest body........");
//        posts.add(postsTest);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);

        Post post1 = new Post("post1 title", "post1 body.......");
        model.addAttribute("post1", post1);
        posts.add(post1);

        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreatePost() {
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost() {
        return "/posts/create";
    }

}