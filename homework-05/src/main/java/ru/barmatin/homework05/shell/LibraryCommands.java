package ru.barmatin.homework05.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.barmatin.homework05.service.LibraryGetService;
import ru.barmatin.homework05.service.LibraryOutputService;
import ru.barmatin.homework05.service.LibraryUpdateService;



@ShellComponent
public class LibraryCommands {
    private final LibraryGetService libraryGetService;
    private final LibraryOutputService libraryOutputService;
    private final LibraryUpdateService libraryUpdateService;

    @Autowired
    public LibraryCommands(LibraryGetService libraryGetService, LibraryOutputService libraryOutputService, LibraryUpdateService libraryUpdateService) {
        this.libraryGetService = libraryGetService;
        this.libraryOutputService = libraryOutputService;
        this.libraryUpdateService = libraryUpdateService;
    }

    @ShellMethod(value = "Show all available books", key = {"show-all-available-books"})
    public void showAllAvailableBooks() {
        libraryOutputService.showBookList(libraryGetService.getAllAvailableBooks());
    }

    @ShellMethod(value = "Show all books by author name", key = {"show-all-books-by-author-name"})
    public void showAllBooksByAuthorNameContains(String text) {
        libraryOutputService.showBookList(libraryGetService.getAllBooksByAuthorNameContains(text));
    }

    @ShellMethod(value = "Show all books by book name", key = {"show-all-books-by-book-name"})
    public void showAllBooksByBookNameContains(String text) {
        libraryOutputService.showBookList(libraryGetService.getAllBooksByBookNameContains(text));
    }

    @ShellMethod(value = "Show all books by genre", key = {"show-all-books-by-genre"})
    public void showAllBooksByGenre(String text) {
        libraryOutputService.showBookList(libraryGetService.getAllBooksByGenreNameContains(text));
    }

    @ShellMethod(value = "Show all genres", key = {"show-all-genres"})
    public void showAllGenres() {
        libraryOutputService.showGenreList(libraryGetService.getAllGenres());
    }

    @ShellMethod(value = "Show all authors", key = {"show-all-authors"})
    public void showAllAuthors() {
        libraryOutputService.showAuthorList(libraryGetService.getAllAuthors());
    }

    @ShellMethod(value = "Delete book by id", key = {"delete-book-by-id"})
    public void deleteBookById(long id) {
        libraryUpdateService.deleteBookById(id);
    }

    @ShellMethod(value = "Add new book", key = {"add-new-book"})
    public void addNewBook() {
        libraryUpdateService.addNewBook();
    }

}
