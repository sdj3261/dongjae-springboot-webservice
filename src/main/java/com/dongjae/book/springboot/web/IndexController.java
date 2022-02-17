package com.dongjae.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    // View resolver에 의해 src/main/resources/templates/index.mustache 가 실행

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

}
