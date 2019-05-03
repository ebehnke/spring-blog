package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RollDiceController {
    List<Integer> dieSides = new ArrayList<>();

    @GetMapping("/roll-dice")
    public String hi(Model model) {
        double randomNum = 0;
        model.addAttribute("randomNum", randomNum);
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{urlNum}")
    public String rollNum(@PathVariable double urlNum, Model model) {
        double randomNum = (long) (Math.random() * 6) + 1;
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