package ru.barmatin.homework07.service.comment;

import ru.barmatin.homework07.domain.Comment;

import java.util.List;

public interface CommentOutputService {

    void showCommentList(List<Comment> commentList);
}
