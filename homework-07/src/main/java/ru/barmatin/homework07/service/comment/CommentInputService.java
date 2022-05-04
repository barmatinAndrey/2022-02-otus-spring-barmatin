package ru.barmatin.homework07.service.comment;

import ru.barmatin.homework07.domain.Comment;

public interface CommentInputService {

    Comment getCommentFromInput(boolean isNewComment);
}
