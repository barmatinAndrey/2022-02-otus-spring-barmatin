package ru.barmatin.collectiveblog.service.post;

import ru.barmatin.collectiveblog.domain.Post;
import java.util.List;

public interface PostService {

    List<Post> getAll();

    List<Post> getAllByPostCategoryId(long postCategoryId);

    List<Post> getAllByTagName(String tagName);

    Post getById(long id);

    Post getNew();

    void savePost(Post post);

    void deletePostById(long id);

}
