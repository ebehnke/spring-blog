package com.codeup.blog;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;

@Entity
@Table(name="posts")
public class Post {
    @Id @GeneratedValue
    private long id;
    @Column(nullable = false, length = 100, name = "title")
    private String title;
    @Column(nullable = false)
    private String body;
    @Column (length = 100)
    private String authorEmail;

    public Post(String title, String body, String authorEmail, long id) {
        this.title = title;
        this.body = body;
        this.authorEmail = authorEmail;
        this.id = id;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

//    public boolean contains( String[] array, String key) {
//        return Arrays.asList(array).contains(key);
//    }

//    public static void main(String[] args) {
//        String[] search = new String[] {"red", "orange", "yellow", "green", "blue", "indigo", "violet"};
//
//        int[] nums = new int[] {6,7,8,9,0,1,2,3,9,8,8,5,4,3};
//
//        System.out.println(Arrays.toString(search));
//        System.out.println(Arrays.toString(nums) + " before sort.");
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums) + " after sort");
//
//        Post asdf = new Post("asdf", "ASdf");
//
//
//        boolean s1 = asdf.contains(search, "purple");
//        boolean s2 = asdf.contains(search, "violet");
//
//        System.out.println("" + s1 + s2);
//
//        boolean s3 = Arrays.asList(search).contains("blue");
//
//        System.out.println(s3);
//
//    }

}
