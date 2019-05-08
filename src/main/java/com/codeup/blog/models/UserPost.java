//package com.codeup.blog.models;
//
//import com.codeup.blog.models.User;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "user_posts")
//public class UserPost {
//
//    @Id
//    @GeneratedValue
//    private long id;
//
//    @Column(nullable = false)
//    private String title;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    public UserPost() {
//    }
//
//    public UserPost(String title, User user) {
//        this.title = title;
//        this.user = user;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//}
//
