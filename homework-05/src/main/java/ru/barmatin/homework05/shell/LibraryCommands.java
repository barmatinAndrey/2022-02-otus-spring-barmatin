package ru.barmatin.homework05.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.barmatin.homework05.domain.Book;
import ru.barmatin.homework05.service.*;


@ShellComponent
public class LibraryCommands {
    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;
    private final BookOutputService bookOutputService;
    private final GenreOutputService genreOutputService;
    private final AuthorOutputService authorOutputService;
    private final BookInputService bookInputService;

    @Autowired
    public LibraryCommands(BookService bookService, GenreService genreService, AuthorService authorService,
                           BookOutputService bookOutputService, GenreOutputService genreOutputService, AuthorOutputService authorOutputService,
                           BookInputService bookInputService) {
        this.bookService = bookService;
        this.genreService = genreService;
        this.authorService = authorService;
        this.bookOutputService = bookOutputService;
        this.genreOutputService = genreOutputService;
        this.authorOutputService = authorOutputService;
        this.bookInputService = bookInputService;
    }

    @ShellMethod(value = "Show book by id", key = {"sb" ,"show-book-by-id"})
    public void showBookById(long id) {
        bookOutputService.showBook(bookService.getBookById(id));
    }

    @ShellMethod(value = "Show all available books", key = {"sab" ,"show-all-available-books"})
    public void showAllAvailableBooks() {
        bookOutputService.showBookList(bookService.getAllAvailableBooks());
    }

    @ShellMethod(value = "Show all genres", key = {"show-all-genres"})
    public void showAllGenres() {
        genreOutputService.showGenreList(genreService.getAllGenres());
    }

    @ShellMethod(value = "Show all authors", key = {"show-all-authors"})
    public void showAllAuthors() {
        authorOutputService.showAuthorList(authorService.getAllAuthors());
    }

    @ShellMethod(value = "Delete book by id", key = {"delete-book-by-id"})
    public void deleteBookById(long id) {
        bookService.deleteBookById(id);
    }

    @ShellMethod(value = "Add new book", key = {"anb", "add-new-book"})
    public void addNewBook() {
        Book book = bookInputService.getBookFromInput(true);
        bookService.addNewBook(book);
    }

    @ShellMethod(value = "Edit book", key = {"eb", "edit-book"})
    public void editBook() {
        Book book = bookInputService.getBookFromInput(false);
        bookService.editBook(book);
    }

}
