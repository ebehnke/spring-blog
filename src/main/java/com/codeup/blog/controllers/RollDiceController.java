package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RollDiceController {
    List<Integer> dieSides = new ArrayList<>();

    @GetMapping("/roll-dice")
    public String hi(Model model) {
        int randomNum = 0;
        model.addAttribute("randomNum", randomNum);
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{urlNum}")
    public String rollNum(@PathVariable int urlNum, Model model) {
        int randomNum = (int) (Math.random() * 6) + 1;
        boolean correctPrediction = false;
        model.addAttribute("randomNum", randomNum);
        model.addAttribute("urlNum", urlNum);


        if (urlNum == randomNum) {
            correctPrediction = true;
        }
        model.addAttribute("correctPrediction", correctPrediction);

        return "roll-dice";
    }

}