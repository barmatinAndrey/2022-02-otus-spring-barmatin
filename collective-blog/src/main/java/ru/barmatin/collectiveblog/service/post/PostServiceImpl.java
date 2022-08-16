package ru.barmatin.collectiveblog.service.post;

import org.springframework.stereotype.Service;
import ru.barmatin.collectiveblog.domain.Post;
import ru.barmatin.collectiveblog.repository.PostRepository;
import java.util.List;

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
}
