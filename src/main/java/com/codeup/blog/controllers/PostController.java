package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postsRepo;
    private final UserRepository usersRepo;

    public PostController(PostRepository postsRepo, UserRepository usersRepo) {
        this.postsRepo = postsRepo;
        this.usersRepo = usersRepo;
    }

    @GetMapping("/posts")
    public String showPosts(Model model) {
//        List<Post> posts = IteratorUtils.toList(postsRepo.findAll().iterator());
//
//        for (Post post : posts) {
//            System.out.println(post.getId());
//            System.out.println(post.getTitle());
//        }

        model.addAttribute("posts", postsRepo.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable Long id, Model model) {

        User author = usersRepo.findOne(1L);
        model.addAttribute("author", author);

        Post post = postsRepo.findOne(id);
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreatePost(Model model) {
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
//    public String createPost(@RequestParam String title, @RequestParam String body) {
    public String createPost(@ModelAttribute Post post) {

//        User author = new User("create", "password", "create@email.com");

//        User user = new User();
//        user = usersRepo.findOne(2);
//        usersRepo.save(author);

//        Post newPost = new Post(title, body, usersRepo.findOne((long)1));
//        UserController usersRepo;
        post.setAuthor(usersRepo.findOne(1L));
        postsRepo.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditPost(@PathVariable Long id, Model model){
        Post post = postsRepo.findOne(id);

        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable Long id, @RequestParam String title, @RequestParam String body){
//    public String editPost(@PathVariable Long id, @ModelAttribute Post post) {
        Post post = postsRepo.findOne(id);
        post.setTitle(title);
        post.setBody(body);
        postsRepo.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable Long id){

        postsRepo.deleteById(id);

        return "redirect:/posts";
    }

}

    //// services
//    @PostMapping("/posts/email")
//    @ResponseBody
//    public String emailPost() {
//        Post emailPost = new Post("emailTitle", "emailBody", "email@email.com", 50);
//        emailPost.setAuthorEmail("erik.behnke@gmail.com");

//        EmailService emailService = new EmailService();

//        return "/posts/email";


//}