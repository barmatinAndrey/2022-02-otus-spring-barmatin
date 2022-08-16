package ru.barmatin.collectiveblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
