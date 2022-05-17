package ru.barmatin.homework09.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework09.domain.Author;
import ru.barmatin.homework09.domain.Book;
import ru.barmatin.homework09.domain.Comment;
import ru.barmatin.homework09.service.io.IOService;
import ru.barmatin.homework09.service.message.MessageService;

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
        long commentId = 0;
        if (!isNewComment) {
            ioService.outputString(messageService.getMessage("strings.enter.comment.id.to.edit")+" ");
            commentId = ioService.readInt(messageService.getMessage("strings.not.number")+" ");
        }
        ioService.outputString(messageService.getMessage("strings.enter.book.id")+" ");
        long bookId = ioService.readInt(messageService.getMessage("strings.not.number")+" ");
        ioService.outputString(messageService.getMessage("strings.enter.comment.text")+" ");
        String commentText = ioService.readString();
        Book book = new Book(bookId, "", new Author(0, "", "", ""), new ArrayList<>());
        return new Comment(commentId, book, commentText);
    }

}
