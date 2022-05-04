package ru.barmatin.homework07.service.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework07.domain.Book;
import ru.barmatin.homework07.domain.Comment;
import ru.barmatin.homework07.service.author.AuthorOutputService;
import ru.barmatin.homework07.service.author.AuthorService;
import ru.barmatin.homework07.service.book.BookInputService;
import ru.barmatin.homework07.service.book.BookOutputService;
import ru.barmatin.homework07.service.book.BookService;
import ru.barmatin.homework07.service.comment.CommentInputService;
import ru.barmatin.homework07.service.comment.CommentService;
import ru.barmatin.homework07.service.genre.GenreOutputService;
import ru.barmatin.homework07.service.genre.GenreService;

@Service
public class LibraryServiceImpl implements LibraryService {
    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;
    private final BookOutputService bookOutputService;
    private final GenreOutputService genreOutputService;
    private final AuthorOutputService authorOutputService;
    private final BookInputService bookInputService;
    private final CommentService commentService;
    private final CommentInputService commentInputService;

    @Autowired
    public LibraryServiceImpl(BookService bookService, GenreService genreService, AuthorService authorService,
                           BookOutputService bookOutputService, GenreOutputService genreOutputService, AuthorOutputService authorOutputService,
                           BookInputService bookInputService, CommentService commentService,
                           CommentInputService commentInputService) {
        this.bookService = bookService;
        this.genreService = genreService;
        this.authorService = authorService;
        this.bookOutputService = bookOutputService;
        this.genreOutputService = genreOutputService;
        this.authorOutputService = authorOutputService;
        this.bookInputService = bookInputService;
        this.commentService = commentService;
        this.commentInputService = commentInputService;
    }

    @Override
    public void showBookById(long id) {
        bookOutputService.showBook(bookService.getBookById(id));
    }

    @Override
    public void showAllAvailableBooks() {
        bookOutputService.showBookList(bookService.getAllAvailableBooks());
    }

    @Override
    public void showAllGenres() {
        genreOutputService.showGenreList(genreService.getAllGenres());
    }

    @Override
    public void showAllAuthors() {
        authorOutputService.showAuthorList(authorService.getAllAuthors());
    }

    @Override
    public void deleteBookById(long id) {
        bookService.deleteBookById(id);
    }

    @Override
    public void addNewBook() {
        Book book = bookInputService.getBookFromInput(true);
        bookService.saveBook(book);
    }

    @Override
    public void editBook() {
        Book book = bookInputService.getBookFromInput(false);
        bookService.saveBook(book);
    }

    @Override
    public void addNewComment() {
        Comment comment = commentInputService.getCommentFromInput(true);
        commentService.saveComment(comment);
    }

    @Override
    public void editComment() {
        Comment comment = commentInputService.getCommentFromInput(false);
        commentService.saveComment(comment);
    }

    @Override
    public void deleteCommentById(long id) {
        commentService.deleteCommentById(id);
    }

}
