package ru.barmatin.homework08.service.comment;

import ru.barmatin.homework08.domain.Comment;

public interface CommentInputService {

    Comment getCommentFromInput(boolean isNewComment);
}
