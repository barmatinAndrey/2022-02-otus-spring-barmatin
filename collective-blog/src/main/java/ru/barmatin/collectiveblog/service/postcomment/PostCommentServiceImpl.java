package ru.barmatin.collectiveblog.service.postcomment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.barmatin.collectiveblog.domain.Post;
import ru.barmatin.collectiveblog.domain.PostComment;
import ru.barmatin.collectiveblog.dto.PostCommentDto;
import ru.barmatin.collectiveblog.repository.PostCommentRepository;
import ru.barmatin.collectiveblog.service.mapping.MappingService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostCommentServiceImpl implements PostCommentService {
    private final PostCommentRepository postCommentRepository;
    private final MappingService mappingService;

    @Autowired
    public PostCommentServiceImpl(PostCommentRepository postCommentRepository, MappingService mappingService) {
        this.postCommentRepository = postCommentRepository;
        this.mappingService = mappingService;
    }

    @Transactional(readOnly = true)
    @Override
    public List<PostCommentDto> getAllByPostId(long postId) {
        List<PostComment> postCommentList = postCommentRepository.findAllByPostId(postId);
        List<PostCommentDto> postCommentDtoList = new ArrayList<>();
        for (PostComment postComment: postCommentList) {
            postCommentDtoList.add(mappingService.mapPostCommentToDto(postComment));
        }
        return postCommentDtoList;
    }

    @Override
    public void savePostComment(PostComment postComment) {
       postCommentRepository.save(postComment);
    }

    @Override
    public void deletePostCommentById(long id) {
        postCommentRepository.deleteById(id);
    }

}
