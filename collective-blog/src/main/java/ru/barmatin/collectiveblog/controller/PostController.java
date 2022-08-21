package ru.barmatin.collectiveblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.barmatin.collectiveblog.domain.BlogUser;
import ru.barmatin.collectiveblog.domain.Post;
import ru.barmatin.collectiveblog.service.bloguser.BlogUserService;
import ru.barmatin.collectiveblog.service.post.PostService;

import java.util.Date;
import java.util.List;


@RestController
public class PostController {
    private final BlogUserService blogUserService;
    private final PostService postService;

    @Autowired
    public PostController(BlogUserService blogUserService, PostService postService) {
        this.blogUserService = blogUserService;
        this.postService = postService;
    }

    @GetMapping("/api/post")
    public List<Post> getAll() {
        return postService.getAll();
    }

    @GetMapping("/api/post/{id}")
    public Post getPost(@PathVariable String id) {
        if (id.equals("new")) {
            String login = SecurityContextHolder.getContext().getAuthentication().getName();
            BlogUser blogUser = blogUserService.getBlogUserByUsername(login);
            Post post = new Post();
            if (blogUser != null) {
                post.setVisible(blogUser.getRole().equals("ADMIN"));
            }
            post.setBlogUser(blogUser);
            return post;
        }
        else {
            return postService.getById(Long.parseLong(id));
        }
    }

    @PostMapping(path = "/api/post", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public RedirectView savePost(@RequestBody Post post) {
        post.setPostDate(new Date());
        postService.savePost(post);
        return new RedirectView("/");
    }
}
