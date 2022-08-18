package ru.barmatin.collectiveblog.service.postcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.collectiveblog.domain.PostCategory;
import ru.barmatin.collectiveblog.repository.PostCategoryRepository;
import java.util.List;

@Service
public class PostCategoryServiceImpl implements PostCategoryService {
    private final PostCategoryRepository postCategoryRepository;

    @Autowired
    public PostCategoryServiceImpl(PostCategoryRepository postCategoryRepository) {
        this.postCategoryRepository = postCategoryRepository;
    }

    @Override
    public List<PostCategory> getAll() {
        return postCategoryRepository.findAllByOrderByName();
    }

}
