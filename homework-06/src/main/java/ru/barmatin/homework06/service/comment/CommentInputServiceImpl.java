package ru.barmatin.homework06.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework06.domain.Author;
import ru.barmatin.homework06.domain.Book;
import ru.barmatin.homework06.domain.Comment;
import ru.barmatin.homework06.service.IOService;
import ru.barmatin.homework06.service.MessageService;

import javax.transaction.Transactional;
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

    @Transactional
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
