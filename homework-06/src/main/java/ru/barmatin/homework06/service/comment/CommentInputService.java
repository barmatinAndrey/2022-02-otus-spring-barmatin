package ru.barmatin.homework06.service.comment;

import ru.barmatin.homework06.domain.Comment;

public interface CommentInputService {

    Comment getCommentFromInput(boolean isNewComment);
}
