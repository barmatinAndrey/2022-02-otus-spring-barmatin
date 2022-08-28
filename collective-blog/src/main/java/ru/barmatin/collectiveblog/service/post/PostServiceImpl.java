package ru.barmatin.collectiveblog.service.post;

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

    public PostServiceImpl(PostRepository postRepository, BlogUserService blogUserService) {
        this.postRepository = postRepository;
        this.blogUserService = blogUserService;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Post> getAll() {
        return postRepository.findAllByOrderByPostDate();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Post> getAllByPostCategoryId(long postCategoryId) {
        return postRepository.findAllByPostCategoryId(postCategoryId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Post> getAllByTagName(String tagName) {
        return postRepository.findAllByPostTagListName(tagName);
    }

    @Transactional(readOnly = true)
    @Override
    public Post getById(long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post getNew() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        BlogUser blogUser = blogUserService.getBlogUserByUsername(login);
        Post post = new Post();
        if (blogUser != null) {
            post.setVisible(blogUser.getRole().equals("ADMIN"));
        }
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

}
