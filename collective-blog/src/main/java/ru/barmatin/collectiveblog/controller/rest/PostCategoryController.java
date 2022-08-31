package ru.barmatin.collectiveblog.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.barmatin.collectiveblog.domain.PostCategory;
import ru.barmatin.collectiveblog.service.postcategory.PostCategoryService;

import java.util.List;

@RestController
public class PostCategoryController {
    private final PostCategoryService postCategoryService;

    @Autowired
    public PostCategoryController(PostCategoryService postCategoryService) {
        this.postCategoryService = postCategoryService;
    }

    @GetMapping("/api/post-category")
    public List<PostCategory> getAll() {
        return postCategoryService.getAll();
    }
}
