package ru.barmatin.homework05.service;

import org.springframework.stereotype.Service;
import ru.barmatin.homework05.domain.Author;
import ru.barmatin.homework05.domain.Book;
import ru.barmatin.homework05.domain.Genre;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookInputServiceImpl implements BookInputService {
    private final MessageService messageService;
    private final IOService ioService;

    public BookInputServiceImpl(IOService ioService, MessageService messageService) {
        this.messageService = messageService;
        this.ioService = ioService;
    }

    @Override
    public Book getBookFromInput(boolean isNewBook) {
        long bookId = 0;
        if (!isNewBook) {
            ioService.outputString(messageService.getMessage("strings.enter.book.id.to.edit")+" ");
            bookId = ioService.readInt(messageService.getMessage("strings.not.number")+" ");
        }
        ioService.outputString(messageService.getMessage("strings.enter.book.name")+" ");
        String bookName = ioService.readString();
        ioService.outputString(messageService.getMessage("strings.enter.author.id")+" ");
        int authorId = ioService.readInt(messageService.getMessage("strings.not.number")+" ");
        List<Genre> genreList = new ArrayList<>();
        ioService.outputString(messageService.getMessage("strings.enter.genre.id")+" ");
        genreList.add(new Genre(ioService.readInt(messageService.getMessage("strings.not.number")+" "), ""));
        while(true) {
            ioService.outputString(messageService.getMessage("strings.enter.genre.id.or.null")+" ");
            int genreId = ioService.readInt(messageService.getMessage("strings.not.number")+" ");
            if (genreId == 0) {
                break;
            }
            else {
                genreList.add(new Genre(genreId, ""));
            }
        }
        return new Book(bookId, bookName, new Author(authorId, "", "", ""), genreList);
    }

}
