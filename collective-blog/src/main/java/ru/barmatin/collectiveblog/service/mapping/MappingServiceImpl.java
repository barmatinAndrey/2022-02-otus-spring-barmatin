package ru.barmatin.collectiveblog.service.mapping;

import org.springframework.stereotype.Service;
import ru.barmatin.collectiveblog.domain.PostComment;
import ru.barmatin.collectiveblog.dto.PostCommentDto;

@Service
public class MappingServiceImpl implements MappingService  {

    @Override
    public PostCommentDto mapPostCommentToDto(PostComment postComment) {
        return new PostCommentDto(
                postComment.getId(),
                postComment.getPostCommentDate(),
                postComment.getContent(),
                postComment.getBlogUser().getId(),
                postComment.getBlogUser().getSurname()+" "+postComment.getBlogUser().getName());
    }
}
