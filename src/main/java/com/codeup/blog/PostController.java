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

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts/index")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts")
    public String viewPosts(Model model) {
        List<Post> posts = new ArrayList<>();

        //inject posts//
        for (int i = 1; i<=5; i++){
            Post postLoop = new Post(("loopTitle - " + i), ("loopBody - " + i),("loopEmail@post" + i + ".com"), i);
            posts.add(postLoop);
        }

//        Post post1 = new Post("postTitle1", "postBody1.........", 1);
//        posts.add(post1);
//        Post post2 = new Post("postTitle2", "postBody2.........", 2);
//        posts.add(post2);

        model.addAttribute("posts", posts);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);

        Post postId = new Post(("post" + id + " title"), ("post" + id + "body......."), ("author" + id + "@email.com"),
                id);
        model.addAttribute("postId", postId);

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

    //// services
    @PostMapping("/posts/email")
    @ResponseBody
    public String emailPost() {
        Post emailPost = new Post("emailTitle", "emailBody", "email@email.com", 50);
        emailPost.setAuthorEmail("erik.behnke@gmail.com");

//        EmailService emailService = new EmailService();

        return "/posts/email";
    }

}