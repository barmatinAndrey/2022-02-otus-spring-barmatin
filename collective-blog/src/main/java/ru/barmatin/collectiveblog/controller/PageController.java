package ru.barmatin.collectiveblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.barmatin.collectiveblog.domain.BlogUser;
import ru.barmatin.collectiveblog.domain.Post;

@Controller
public class PageController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("blogUser", new BlogUser());
        return "registration";
    }

    @GetMapping("/")
    public String postListPage() {
        return "post-list";
    }

    @GetMapping("/post-edit/{id}")
    public String postEditPage(@PathVariable String id) {
        return "post-edit";
    }

}