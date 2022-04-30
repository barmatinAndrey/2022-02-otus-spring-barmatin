package ru.barmatin.homework07.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.barmatin.homework07.service.library.LibraryService;


@ShellComponent
public class LibraryCommands {
    private final LibraryService libraryService;

    @Autowired
    public LibraryCommands(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @ShellMethod(value = "Show book by id", key = {"sb" ,"show-book-by-id"})
    public void showBookById(long id) {
        libraryService.showBookById(id);
    }

    @ShellMethod(value = "Show all available books", key = {"sab" ,"show-all-available-books"})
    public void showAllAvailableBooks() {
        libraryService.showAllAvailableBooks();
    }

    @ShellMethod(value = "Show all genres", key = {"show-all-genres"})
    public void showAllGenres() {
        libraryService.showAllGenres();
    }

    @ShellMethod(value = "Show all authors", key = {"show-all-authors"})
    public void showAllAuthors() {
        libraryService.showAllAuthors();
    }

    @ShellMethod(value = "Delete book by id", key = {"delete-book-by-id"})
    public void deleteBookById(long id) {
        libraryService.deleteBookById(id);
    }

    @ShellMethod(value = "Add new book", key = {"anb", "add-new-book"})
    public void addNewBook() {
        libraryService.addNewBook();
    }

    @ShellMethod(value = "Edit book", key = {"eb", "edit-book"})
    public void editBook() {
        libraryService.editBook();
    }

    @ShellMethod(value = "Show comments by book id", key = {"scbb" ,"show-comments-by-book-id"})
    public void showCommentsByBookId(long bookId) {
       libraryService.showCommentsByBookId(bookId);
    }

    @ShellMethod(value = "Add new comment", key = {"anc", "add-new-comment"})
    public void addNewComment() {
        libraryService.addNewComment();
    }

    @ShellMethod(value = "Edit comment", key = {"ec", "edit-comment"})
    public void editComment() {
        libraryService.editComment();
    }

    @ShellMethod(value = "Delete comment by id", key = {"delete-comment-by-id"})
    public void deleteCommentById(long id) {
        libraryService.deleteCommentById(id);
    }

}
