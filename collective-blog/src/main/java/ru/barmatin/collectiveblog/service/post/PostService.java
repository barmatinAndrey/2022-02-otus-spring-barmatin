package ru.barmatin.collectiveblog.service.post;

import ru.barmatin.collectiveblog.domain.Post;
import java.util.List;

public interface PostService {

    List<Post> getAllByVisibility(boolean isVisible);

    List<Post> getAllByPostCategoryId(long postCategoryId, boolean isVisible);

    List<Post> getAllByTagName(String tagName, boolean isVisible);

    Post getById(long id);

    List<Post> getAllByBlogUserId(long blogUserId);

    Post getNew();

    void savePost(Post post);

    void deletePostById(long id);

}
