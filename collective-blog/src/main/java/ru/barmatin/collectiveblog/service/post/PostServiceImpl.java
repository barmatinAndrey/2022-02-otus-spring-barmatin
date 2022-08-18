package ru.barmatin.collectiveblog.service.post;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.barmatin.collectiveblog.domain.Post;
import ru.barmatin.collectiveblog.repository.PostRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAllByOrderByPostDate();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Post> getById(long id) {
        return postRepository.findById(id);
    }
}
