package ru.barmatin.collectiveblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.barmatin.collectiveblog.domain.BlogUser;

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
    public String listPage() {
        return "list";
    }

}