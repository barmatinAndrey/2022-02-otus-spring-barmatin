package ru.barmatin.collectiveblog.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.barmatin.collectiveblog.domain.BlogUser;
import ru.barmatin.collectiveblog.domain.Post;
import ru.barmatin.collectiveblog.repository.PostRepository;
import ru.barmatin.collectiveblog.service.bloguser.BlogUserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final BlogUserService blogUserService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, BlogUserService blogUserService) {
        this.postRepository = postRepository;
        this.blogUserService = blogUserService;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Post> getAllByVisibility(boolean isVisible) {
        return postRepository.findAllByIsVisibleOrderByPostDateDesc(isVisible);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Post> getAllByPostCategoryId(long postCategoryId, boolean isVisible) {
        return postRepository.findAllByPostCategoryIdAndIsVisibleOrderByPostDateDesc(postCategoryId, isVisible);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Post> getAllByTagName(String tagName, boolean isVisible) {
        return postRepository.findAllByPostTagListNameAndIsVisibleOrderByPostDateDesc(tagName, isVisible);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Post> getAllByBlogUserId(long blogUserId) {
        return postRepository.findAllByBlogUserIdOrderByPostDateDesc(blogUserId);
    }

    @Transactional(readOnly = true)
    @Override
    public Post getById(long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post getNew() {
        Post post = new Post();
        BlogUser blogUser = getBlogUser();
        post.setVisible(blogUser.getRole().equals("ADMIN"));
        post.setBlogUser(blogUser);
        post.setPostTagList(new ArrayList<>());
        return post;
    }

    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePostById(long id) {
        postRepository.deleteById(id);
    }

    private BlogUser getBlogUser() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        return blogUserService.getBlogUserByUsername(login);
    }

}
