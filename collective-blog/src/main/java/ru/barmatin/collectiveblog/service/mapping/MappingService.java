package ru.barmatin.collectiveblog.service.mapping;

import ru.barmatin.collectiveblog.domain.PostComment;
import ru.barmatin.collectiveblog.dto.PostCommentDto;

public interface MappingService {

    PostCommentDto mapPostCommentToDto(PostComment postComment);

}
