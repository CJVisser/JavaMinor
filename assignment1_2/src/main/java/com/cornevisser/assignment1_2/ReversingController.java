package com.cornevisser.assignment1_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReversingController {
    @GetMapping("/reverse")
    public String reverser(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    @GetMapping("/counter")
    public int counter(String text){
        return text.split(" ").length;
    }
}
