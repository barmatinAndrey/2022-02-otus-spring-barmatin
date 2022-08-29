package ru.barmatin.collectiveblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.barmatin.collectiveblog.domain.Post;
import ru.barmatin.collectiveblog.service.bloguser.BlogUserService;
import ru.barmatin.collectiveblog.service.post.PostService;
import ru.barmatin.collectiveblog.service.posttag.PostTagService;
import java.util.Date;
import java.util.List;


@RestController
public class PostController {
    private final PostService postService;
    private final PostTagService postTagService;

    @Autowired
    public PostController(PostService postService, PostTagService postTagService) {
        this.postService = postService;
        this.postTagService = postTagService;
    }

    @GetMapping("/api/post")
    public List<Post> getAll(@RequestParam(name = "isVisible", required = false) Boolean isVisible,
                             @RequestParam(name = "postCategoryId", required = false) Long postCategoryId,
                             @RequestParam(name = "tagName", required = false) String tagName) {
        if (isVisible == null) {
            isVisible = true;
        }
        if (postCategoryId != null) {
            return postService.getAllByPostCategoryId(postCategoryId);
        }
        else if (tagName!=null && !tagName.isEmpty()) {
            return postService.getAllByTagName(tagName);
        }
        else {
            return postService.getAllByVisibility(isVisible);
        }
    }

    @GetMapping("/api/post/{id}")
    public Post getPost(@PathVariable String id) {
        if (id.equals("new")) {
            return postService.getNew();
        }
        else {
            return postService.getById(Long.parseLong(id));
        }
    }

    @PostMapping(path = "/api/post", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void savePost(@RequestBody Post post) {
        if (post.getPostDate() == null) {
            post.setPostDate(new Date());
        }
        post.setPostTagList(postTagService.getExistingPostTagList(post.getPostTagList()));
        postService.savePost(post);
    }

    @DeleteMapping("/api/post/{id}")
    public void deletePostById(@PathVariable long id) {
        postService.deletePostById(id);
    }
}
