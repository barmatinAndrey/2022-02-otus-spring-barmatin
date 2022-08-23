package ru.barmatin.collectiveblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.barmatin.collectiveblog.service.postcomment.PostCommentService;
import java.util.List;

@RestController
public class PostCommentController {
    private final PostCommentService postCommentService;

    @Autowired
    public PostCommentController(PostCommentService postCommentService) {
        this.postCommentService = postCommentService;
    }

    @GetMapping("/api/post-comment")
    public List<String> getAll(@RequestParam("postId") long postId) {
        return postCommentService.getAllContentByPostId(postId);
    }
}
