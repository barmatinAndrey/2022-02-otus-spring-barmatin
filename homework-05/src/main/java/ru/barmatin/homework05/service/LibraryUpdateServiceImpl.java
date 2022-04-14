package ru.barmatin.homework05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework05.dao.AuthorDao;
import ru.barmatin.homework05.dao.BookDao;
import ru.barmatin.homework05.dao.GenreDao;
import ru.barmatin.homework05.dao.ext.BookGenreRelation;
import ru.barmatin.homework05.domain.Author;
import ru.barmatin.homework05.domain.Book;
import ru.barmatin.homework05.domain.Genre;

import java.util.ArrayList;
import java.util.List;


@Service
public class LibraryUpdateServiceImpl implements LibraryUpdateService {
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;
    private final IOService ioService;
    private final MessageService messageService;

    @Autowired
    public LibraryUpdateServiceImpl(BookDao bookDao, AuthorDao authorDao, GenreDao genreDao, IOService ioService, MessageService messageService) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.genreDao = genreDao;
        this.ioService = ioService;
        this.messageService = messageService;
    }

    @Override
    public void deleteBookById(long id) {
        bookDao.deleteById(id);
    }

    @Override
    public void addNewBook() {
        Book book = getNewBookFromInput();
        book.setId(bookDao.count()+1);
        checkAuthor(book);
        checkGenreList(book);
        bookDao.insert(book);
    }

    private Book getNewBookFromInput(){
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

    private void checkAuthor(Book book) {
        long count = authorDao.getCountByName(book.getAuthor().getSurname(), book.getAuthor().getName(), book.getAuthor().getPatronym());
        if (count == 0) {
            long authorId = authorDao.count()+1;
            book.getAuthor().setId(authorId);
            authorDao.insert(book.getAuthor());
        }
        else {
            long authorId = authorDao.getIdByName(book.getAuthor().getSurname(), book.getAuthor().getName(), book.getAuthor().getPatronym());
            book.getAuthor().setId(authorId);
        }
    }

    private void checkGenreList(Book book) {
        for (Genre genre: book.getGenreList()) {
            long count = genreDao.getCountByName(genre.getName());
            if (count == 0) {
                long genreId = genreDao.count()+1;
                genre.setId(genreId);
                genreDao.insert(genre);
            }
            else {
                long genreId = genreDao.getIdByName(genre.getName());
                genre.setId(genreId);
            }
            bookDao.insert(new BookGenreRelation(book.getId(), genre.getId()));
        }
    }
}
