package ru.barmatin.homework05.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.barmatin.homework05.service.LibraryGetService;
import ru.barmatin.homework05.service.LibraryUpdateService;



@ShellComponent
public class LibraryCommands {
    private final LibraryGetService libraryGetService;
    private final LibraryUpdateService libraryUpdateService;

    @Autowired
    public LibraryCommands(LibraryGetService libraryGetService, LibraryUpdateService libraryUpdateService) {
        this.libraryGetService = libraryGetService;
        this.libraryUpdateService = libraryUpdateService;
    }

    @ShellMethod(value = "Show all available books", key = {"show-all-available-books"})
    public void showAllAvailableBooks() {
        libraryGetService.showAllAvailableBooks();
    }

    @ShellMethod(value = "Show all books by author name", key = {"show-all-books-by-author-name"})
    public void showAllBooksByAuthorName(String textToSearch) {
        libraryGetService.showAllBooksByAuthorName(textToSearch);
    }

    @ShellMethod(value = "Show all books by book name", key = {"show-all-books-by-book-name"})
    public void showAllBooksByBookName(String textToSearch) {
        libraryGetService.showAllBooksByBookName(textToSearch);
    }

    @ShellMethod(value = "Show all books by genre", key = {"show-all-books-by-genre"})
    public void showAllBooksByGenre(String genreName) {
        libraryGetService.showAllBooksByGenre(genreName);
    }

    @ShellMethod(value = "Show all genres", key = {"show-all-genres"})
    public void showAllGenres() {
        libraryGetService.showAllGenres();
    }

    @ShellMethod(value = "Show all authors", key = {"show-all-authors"})
    public void showAllAuthors() {
        libraryGetService.showAllAuthors();
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
