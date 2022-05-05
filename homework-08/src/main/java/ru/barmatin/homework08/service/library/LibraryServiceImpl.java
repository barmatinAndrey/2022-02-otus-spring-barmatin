package ru.barmatin.homework08.service.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework08.domain.Book;
import ru.barmatin.homework08.domain.Comment;
import ru.barmatin.homework08.dto.BookInputDTO;
import ru.barmatin.homework08.service.author.AuthorOutputService;
import ru.barmatin.homework08.service.author.AuthorService;
import ru.barmatin.homework08.service.book.BookInputService;
import ru.barmatin.homework08.service.book.BookMappingService;
import ru.barmatin.homework08.service.book.BookOutputService;
import ru.barmatin.homework08.service.book.BookService;
import ru.barmatin.homework08.service.comment.CommentInputService;
import ru.barmatin.homework08.service.comment.CommentService;
import ru.barmatin.homework08.service.genre.GenreOutputService;
import ru.barmatin.homework08.service.genre.GenreService;

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
    private final BookMappingService bookMappingService;

    @Autowired
    public LibraryServiceImpl(BookService bookService, GenreService genreService, AuthorService authorService,
                              BookOutputService bookOutputService, GenreOutputService genreOutputService, AuthorOutputService authorOutputService,
                              BookInputService bookInputService, CommentService commentService,
                              CommentInputService commentInputService, BookMappingService bookMappingService) {
        this.bookService = bookService;
        this.genreService = genreService;
        this.authorService = authorService;
        this.bookOutputService = bookOutputService;
        this.genreOutputService = genreOutputService;
        this.authorOutputService = authorOutputService;
        this.bookInputService = bookInputService;
        this.commentService = commentService;
        this.commentInputService = commentInputService;
        this.bookMappingService = bookMappingService;
    }

    @Override
    public void showBookById(String id) {
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
    public void deleteBookById(String id) {
        bookService.deleteBookById(id);
        commentService.deleteCommentByBookId(id);
    }

    @Override
    public void addNewBook() {
        BookInputDTO bookInputDTO = bookInputService.getBookInputDTO(true);
        Book book = bookMappingService.mapBookInput(bookInputDTO);
        bookService.saveBook(book);
    }

    @Override
    public void editBook() {
        BookInputDTO bookInputDTO = bookInputService.getBookInputDTO(false);
        Book book = bookMappingService.mapBookInput(bookInputDTO);
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
    public void deleteCommentById(String id) {
        commentService.deleteCommentById(id);
    }

}
