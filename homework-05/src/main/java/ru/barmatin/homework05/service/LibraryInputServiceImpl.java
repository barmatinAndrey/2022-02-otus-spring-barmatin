package ru.barmatin.homework05.service;

import org.springframework.stereotype.Service;
import ru.barmatin.homework05.domain.Author;
import ru.barmatin.homework05.domain.Book;
import ru.barmatin.homework05.domain.Genre;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryInputServiceImpl implements LibraryInputService {
    private final MessageService messageService;
    private final IOService ioService;

    public LibraryInputServiceImpl(IOService ioService, MessageService messageService) {
        this.messageService = messageService;
        this.ioService = ioService;
    }

    @Override
    public Book getNewBookFromInput() {
        ioService.outputString(messageService.getMessage("strings.enter.book.name")+" ");
        String bookName = ioService.readString();
        ioService.outputString(messageService.getMessage("strings.enter.author.surname")+" ");
        String authorSurname = ioService.readString();
        ioService.outputString(messageService.getMessage("strings.enter.author.name")+" ");
        String authorName = ioService.readString();
        ioService.outputString(messageService.getMessage("strings.enter.author.patronym")+" ");
        String authorPatronym = ioService.readString();
        List<Genre> genreList = new ArrayList<>();
        ioService.outputString(messageService.getMessage("strings.enter.genre")+" ");
        genreList.add(new Genre(0, ioService.readString()));
        while(true) {
            ioService.outputString(messageService.getMessage("strings.enter.genre.or.null")+" ");
            String genre = ioService.readString();
            if (genre.equals("0")) {
                break;
            }
            else {
                genreList.add(new Genre(0, genre));
            }
        }
        return new Book(0, bookName, new Author(0, authorSurname, authorName, authorPatronym), genreList);
    }
}
