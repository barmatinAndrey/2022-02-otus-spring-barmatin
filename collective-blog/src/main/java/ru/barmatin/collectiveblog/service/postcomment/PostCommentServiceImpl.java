package ru.barmatin.collectiveblog.service.postcomment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.collectiveblog.domain.Post;
import ru.barmatin.collectiveblog.domain.PostComment;
import ru.barmatin.collectiveblog.repository.PostCommentRepository;
import java.util.List;

@Service
public class PostCommentServiceImpl implements PostCommentService {
    private final PostCommentRepository postCommentRepository;

    @Autowired
    public PostCommentServiceImpl(PostCommentRepository postCommentRepository) {
        this.postCommentRepository = postCommentRepository;
    }

    @Override
    public List<String> getAllContentByPostId(long postId) {
        return postCommentRepository.findAllContentByPostId(postId);
    }

    @Override
    public void savePostComment(PostComment postComment) {
       postCommentRepository.save(postComment);
    }

}
