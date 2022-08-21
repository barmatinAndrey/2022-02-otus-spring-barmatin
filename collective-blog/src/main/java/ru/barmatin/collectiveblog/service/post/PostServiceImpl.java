package ru.barmatin.collectiveblog.service.post;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.barmatin.collectiveblog.domain.Post;
import ru.barmatin.collectiveblog.repository.PostRepository;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Post> getAll() {
        return postRepository.findAllByOrderByPostDate();
    }

    @Transactional(readOnly = true)
    @Override
    public Post getById(long id) {
        return postRepository.findById(id);
    }

    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }

}
