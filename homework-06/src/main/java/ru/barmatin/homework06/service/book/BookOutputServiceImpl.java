package ru.barmatin.homework06.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework06.domain.Book;
import ru.barmatin.homework06.service.ListConverterService;
import ru.barmatin.homework06.service.OutputService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookOutputServiceImpl implements BookOutputService {
    private final OutputService outputService;
    private final ListConverterService listConverterService;

    @Autowired
    public BookOutputServiceImpl(OutputService outputService, ListConverterService listConverterService) {
        this.outputService = outputService;
        this.listConverterService = listConverterService;
    }

    @Override
    public void showBookList(List<Book> bookList) {
        outputService.outputStringLn(listConverterService.getStringFromBookList(bookList));
    }

    @Override
    public void showBook(Book book) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        outputService.outputStringLn(listConverterService.getStringFromBookList(bookList));
    }

}
