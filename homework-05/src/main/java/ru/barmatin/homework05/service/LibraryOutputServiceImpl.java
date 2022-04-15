package ru.barmatin.homework05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework05.domain.Author;
import ru.barmatin.homework05.domain.Book;
import ru.barmatin.homework05.domain.Genre;

import java.util.List;

@Service
public class LibraryOutputServiceImpl implements LibraryOutputService {
    private final OutputService outputService;
    private final ListConverterService listConverterService;

    @Autowired
    public LibraryOutputServiceImpl(OutputService outputService, ListConverterService listConverterService) {
        this.outputService = outputService;
        this.listConverterService = listConverterService;
    }

    @Override
    public void showBookList(List<Book> bookList) {
        outputService.outputStringLn(listConverterService.getStringFromBookList(bookList));
    }

    @Override
    public void showGenreList(List<Genre> genreList) {
        outputService.outputStringLn(listConverterService.getStringFromGenreList(genreList));
    }

    @Override
    public void showAuthorList(List<Author> authorList) {
        outputService.outputStringLn(listConverterService.getStringFromAuthorList(authorList));
    }

}
