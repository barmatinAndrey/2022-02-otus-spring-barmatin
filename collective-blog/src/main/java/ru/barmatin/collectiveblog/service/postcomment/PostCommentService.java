package ru.barmatin.collectiveblog.service.postcomment;

import java.util.List;

public interface PostCommentService {

    List<String> getAllContentByPostId(long postId);

}
