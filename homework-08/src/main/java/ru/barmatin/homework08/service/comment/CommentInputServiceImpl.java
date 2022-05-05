package ru.barmatin.homework08.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework08.domain.Author;
import ru.barmatin.homework08.domain.Book;
import ru.barmatin.homework08.domain.Comment;
import ru.barmatin.homework08.service.io.IOService;
import ru.barmatin.homework08.service.message.MessageService;

import java.util.ArrayList;

@Service
public class CommentInputServiceImpl implements CommentInputService {
    private final MessageService messageService;
    private final IOService ioService;

    @Autowired
    public CommentInputServiceImpl(IOService ioService, MessageService messageService) {
        this.messageService = messageService;
        this.ioService = ioService;
    }

    @Override
    public Comment getCommentFromInput(boolean isNewComment) {
        String commentId = null;
        if (!isNewComment) {
            ioService.outputString(messageService.getMessage("strings.enter.comment.id.to.edit")+" ");
            commentId = ioService.readString();
        }
        ioService.outputString(messageService.getMessage("strings.enter.book.id")+" ");
        String bookId = ioService.readString();
        ioService.outputString(messageService.getMessage("strings.enter.comment.text")+" ");
        String commentText = ioService.readString();
        return new Comment(commentId, bookId, commentText);
    }

}
