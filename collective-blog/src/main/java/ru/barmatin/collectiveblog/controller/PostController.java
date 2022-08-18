package ru.barmatin.collectiveblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import ru.barmatin.collectiveblog.domain.BlogUser;
import ru.barmatin.collectiveblog.domain.Post;
import ru.barmatin.collectiveblog.service.post.PostService;

import java.util.List;


@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/api/post")
    public List<Post> getAll() {
        return postService.getAll();
    }

    @PostMapping(path = "/api/post", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public RedirectView savePost(Post post) {
        Post p = post;
//        blogUser.setPassword(passwordEncoder.encode(blogUser.getPassword()));
//        blogUser.setRole("USER");
//        blogUserService.saveBlogUser(blogUser);
        return new RedirectView("/");
    }
}
