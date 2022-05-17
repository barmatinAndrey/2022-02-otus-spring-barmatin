package ru.barmatin.homework09.service.comment;

import ru.barmatin.homework09.domain.Comment;

public interface CommentInputService {

    Comment getCommentFromInput(boolean isNewComment);
}
