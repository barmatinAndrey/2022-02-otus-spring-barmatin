package ru.barmatin.collectiveblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.barmatin.collectiveblog.domain.BlogUser;
import ru.barmatin.collectiveblog.service.bloguser.BlogUserService;

@RestController
public class BlogUserController {
    private final BlogUserService blogUserService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public BlogUserController(BlogUserService blogUserService, PasswordEncoder passwordEncoder) {
        this.blogUserService = blogUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(path = "/registration", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void saveBlogUser(BlogUser blogUser) {
        blogUser.setPassword(passwordEncoder.encode(blogUser.getPassword()));
        blogUser.setRole("USER");
        blogUserService.saveBlogUser(blogUser);
    }

}
