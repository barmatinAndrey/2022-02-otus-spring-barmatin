package ru.barmatin.homework06.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.barmatin.homework06.domain.Book;
import ru.barmatin.homework06.domain.Comment;
import ru.barmatin.homework06.service.author.AuthorOutputService;
import ru.barmatin.homework06.service.author.AuthorService;
import ru.barmatin.homework06.service.book.BookInputService;
import ru.barmatin.homework06.service.book.BookOutputService;
import ru.barmatin.homework06.service.book.BookService;
import ru.barmatin.homework06.service.comment.CommentInputService;
import ru.barmatin.homework06.service.comment.CommentOutputService;
import ru.barmatin.homework06.service.comment.CommentService;
import ru.barmatin.homework06.service.genre.GenreOutputService;
import ru.barmatin.homework06.service.genre.GenreService;


@ShellComponent
public class LibraryCommands {
    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;
    private final BookOutputService bookOutputService;
    private final GenreOutputService genreOutputService;
    private final AuthorOutputService authorOutputService;
    private final BookInputService bookInputService;
    private final CommentService commentService;
    private final CommentOutputService commentOutputService;
    private final CommentInputService commentInputService;

    @Autowired
    public LibraryCommands(BookService bookService, GenreService genreService, AuthorService authorService,
                           BookOutputService bookOutputService, GenreOutputService genreOutputService, AuthorOutputService authorOutputService,
                           BookInputService bookInputService, CommentService commentService, CommentOutputService commentOutputService,
                           CommentInputService commentInputService) {
        this.bookService = bookService;
        this.genreService = genreService;
        this.authorService = authorService;
        this.bookOutputService = bookOutputService;
        this.genreOutputService = genreOutputService;
        this.authorOutputService = authorOutputService;
        this.bookInputService = bookInputService;
        this.commentService = commentService;
        this.commentOutputService = commentOutputService;
        this.commentInputService = commentInputService;
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

    @ShellMethod(value = "Show comments by book id", key = {"scbb" ,"show-comments-by-book-id"})
    public void showCommentsByBookId(long bookId) {
        commentOutputService.showCommentList(commentService.getCommentsByBookId(bookId));
    }

    @ShellMethod(value = "Add new comment", key = {"anc", "add-new-comment"})
    public void addNewComment() {
        Comment comment = commentInputService.getCommentFromInput(true);
        commentService.addNewComment(comment);
    }

    @ShellMethod(value = "Edit comment", key = {"ec", "edit-comment"})
    public void editComment() {
        Comment comment = commentInputService.getCommentFromInput(false);
        commentService.editComment(comment);
    }

    @ShellMethod(value = "Delete comment by id", key = {"delete-comment-by-id"})
    public void deleteCommentById(long id) {
        commentService.deleteCommentById(id);
    }

}
