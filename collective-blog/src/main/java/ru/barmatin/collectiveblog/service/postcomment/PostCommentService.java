package ru.barmatin.collectiveblog.service.postcomment;

import ru.barmatin.collectiveblog.domain.PostComment;
import ru.barmatin.collectiveblog.dto.PostCommentDto;

import java.util.List;

public interface PostCommentService {

    List<PostCommentDto> getAllByPostId(long postId);

    void savePostComment(PostComment postComment);

    void deletePostCommentById(long id);

}
