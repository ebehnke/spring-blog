package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }



    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        List<String> names = new ArrayList();

        names.add("john");
        names.add("tom");

        if (name.equals("erik")){
            model.addAttribute("admin", true);
        }
        model.addAttribute("name", name);
        model.addAttribute("names", names);
        return "hello";
    }


}

