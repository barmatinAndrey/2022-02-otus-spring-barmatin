package ru.barmatin.collectiveblog.service.postcomment;

import ru.barmatin.collectiveblog.domain.PostComment;

import java.util.List;

public interface PostCommentService {

    List<String> getAllContentByPostId(long postId);

    void savePostComment(PostComment postComment);

}
