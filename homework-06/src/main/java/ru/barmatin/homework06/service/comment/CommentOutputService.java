package ru.barmatin.homework06.service.comment;

import ru.barmatin.homework06.domain.Comment;

import java.util.List;

public interface CommentOutputService {

    void showCommentList(List<Comment> commentList);
}
