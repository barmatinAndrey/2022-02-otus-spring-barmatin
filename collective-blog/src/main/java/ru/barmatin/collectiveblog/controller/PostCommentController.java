package ru.barmatin.collectiveblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.barmatin.collectiveblog.domain.Post;
import ru.barmatin.collectiveblog.domain.PostComment;
import ru.barmatin.collectiveblog.dto.PostCommentDto;
import ru.barmatin.collectiveblog.service.postcomment.PostCommentService;

import java.util.Date;
import java.util.List;

@RestController
public class PostCommentController {
    private final PostCommentService postCommentService;

    @Autowired
    public PostCommentController(PostCommentService postCommentService) {
        this.postCommentService = postCommentService;
    }

    @GetMapping("/api/post-comment")
    public List<PostCommentDto> getAllContentByPostId(@RequestParam("postId") long postId) {
        List<PostCommentDto> bb = postCommentService.getAllByPostId(postId);
        return postCommentService.getAllByPostId(postId);
    }

    @PostMapping(path = "/api/post-comment", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void savePostComment(@RequestBody PostComment postComment) {
        postComment.setPostCommentDate(new Date());
        postCommentService.savePostComment(postComment);
    }

    @DeleteMapping("/api/post-comment/{id}")
    public void deletePostCommentById(@PathVariable long id) {
        postCommentService.deletePostCommentById(id);
    }
}
