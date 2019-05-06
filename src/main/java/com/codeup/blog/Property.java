//package com.codeup.blog;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="properties")
//public class Property {
//    @Id @GeneratedValue
//    private long id;
//    @Column(nullable = false)
//    private double price;
//    @Column(nullable = false, length = 100)
//    private String title;
//    @Column(nullable = false)
//    private String address;
//
//    public Property(double price, String title, String address) {
//        this.price = price;
//        this.title = title;
//        this.address = address;
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
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
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
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//}
//
