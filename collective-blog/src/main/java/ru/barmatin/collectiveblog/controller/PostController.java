package ru.barmatin.collectiveblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/api/post/{id}")
    public Post getPost(@PathVariable String id) {
//        Post p = new Post();
//        p.setTitle("AAAAdasdasddddddddsaAAa");
        if (id.equals("new")) {
            return new Post();
        }
        else {
            return postService.getById(Long.parseLong(id)).get();
        }
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
