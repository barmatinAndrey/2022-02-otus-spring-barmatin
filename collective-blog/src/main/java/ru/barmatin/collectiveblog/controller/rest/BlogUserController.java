package ru.barmatin.collectiveblog.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
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

    @PostMapping(path = "/api/registration", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public RedirectView saveBlogUser(BlogUser blogUser) {
        blogUser.setPassword(passwordEncoder.encode(blogUser.getPassword()));
        blogUser.setRole("USER");
        blogUserService.saveBlogUser(blogUser);
        return new RedirectView("/login");
    }

    @GetMapping("/api/current-role")
    public BlogUser getCurrentUser() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        BlogUser blogUser = blogUserService.getBlogUserByUsername(login);
        if (blogUser == null) {
            blogUser = new BlogUser();
            blogUser.setRole("ANONYMOUS");
        }
        return blogUser;
    }

}
