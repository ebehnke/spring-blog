package com.codeup.blog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service("mailService")
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from = "abb3f3623b-0dd614@inbox.mailtrap.io";

    public void prepareAndSend(Post post) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(post.getAuthorEmail());
        msg.setSubject(post.getTitle());
        msg.setText(post.getBody());

        try{
            this.emailSender.send(msg);
        } catch (MailException e) {
            // simply log it and go on...
            System.err.println(e.getMessage());
        }
    }
}
