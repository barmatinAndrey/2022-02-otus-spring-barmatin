package ru.barmatin.homework07.service.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.barmatin.homework07.domain.Book;
import ru.barmatin.homework07.domain.Comment;
import ru.barmatin.homework07.service.author.AuthorOutputService;
import ru.barmatin.homework07.service.author.AuthorService;
import ru.barmatin.homework07.service.book.BookInputService;
import ru.barmatin.homework07.service.book.BookOutputService;
import ru.barmatin.homework07.service.book.BookService;
import ru.barmatin.homework07.service.comment.CommentInputService;
import ru.barmatin.homework07.service.comment.CommentOutputService;
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
    private final CommentOutputService commentOutputService;
    private final CommentInputService commentInputService;

    @Autowired
    public LibraryServiceImpl(BookService bookService, GenreService genreService, AuthorService authorService,
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

    @Transactional(readOnly = true)
    @Override
    public void showBookById(long id) {
        bookService.getBookById(id).ifPresent(bookOutputService::showBook);
    }

    @Transactional(readOnly = true)
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

    @Transactional
    @Override
    public void deleteBookById(long id) {
        bookService.deleteBookById(id);
    }

    @Transactional
    @Override
    public void addNewBook() {
        Book book = bookInputService.getBookFromInput(true);
        bookService.saveBook(book);
    }

    @Transactional
    @Override
    public void editBook() {
        Book book = bookInputService.getBookFromInput(false);
        bookService.saveBook(book);
    }

    @Transactional(readOnly = true)
    @Override
    public void showCommentsByBookId(long bookId) {
        commentOutputService.showCommentList(commentService.getCommentsByBookId(bookId));
    }

    @Transactional
    @Override
    public void addNewComment() {
        Comment comment = commentInputService.getCommentFromInput(true);
        commentService.saveComment(comment);
    }

    @Transactional
    @Override
    public void editComment() {
        Comment comment = commentInputService.getCommentFromInput(false);
        commentService.saveComment(comment);
    }

    @Transactional
    @Override
    public void deleteCommentById(long id) {
        commentService.deleteCommentById(id);
    }

}
