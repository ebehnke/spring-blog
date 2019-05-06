package com.codeup.blog;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

//        Post postTest = new Post("postTest Title", "postTest description....", "postTest@email.com");
//        postDao.save(postTest);

//        List<Post> posts = IteratorUtils.toList(postDao.findAll().iterator());
//
//        for (Post post : posts) {
//            System.out.println(post.getId());
//            System.out.println(post.getTitle());
//        }

        model.addAttribute("postsTest", postDao.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/delete/{id}")
    public String remove(@PathVariable long id){

//        model.addAttribute("id", id);

        postDao.deleteById(id);

//        List<Post> posts = IteratorUtils.toList(postDao.findAll().iterator());
//
//        for (Post post : posts) {
//        id = post.getId();
//            if (post.getId() == id) {
//                postDao.deleteById(id);
//                model.addAttribute("id", id);
//            }
//        }

        return "/posts/index";

    }

    @GetMapping("/posts")
    public String viewPosts(Model model) {
//        List<Post> posts = new ArrayList<>();

        //inject posts//
//        for (int i = 1; i<=5; i++){
//            Post postLoop = new Post(("loopTitle - " + i), ("loopBody - " + i),("loopEmail@post" + i + ".com"), i);
//            posts.add(postLoop);
//        }

//        Post post1 = new Post("postTitle1", "postBody1.........", 1);
//        posts.add(post1);
//        Post post2 = new Post("postTitle2", "postBody2.........", 2);
//        posts.add(post2);

//        model.addAttribute("posts", posts);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);

        Post postId = new Post(("post" + id + " title"), ("post" + id + "body......."), ("author" + id + "@email.com"),
                id);
        model.addAttribute("postId", postId);


//        Post post = postDao.findOne(id);



        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreatePost() {
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam String title, @RequestParam String body) {
        Post newPost = new Post(title, body);
        postDao.save(newPost);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditPost(@PathVariable long id, Model model){
        Post post = postDao.findOne(id);



        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@RequestParam String title, @RequestParam String body, @RequestParam String id,
                           @PathVariable long id1){
        Post post = postDao.findOne(Long.valueOf(id));
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);

        return "posts/index";
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