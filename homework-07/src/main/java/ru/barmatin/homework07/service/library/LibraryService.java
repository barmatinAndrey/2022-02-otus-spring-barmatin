package ru.barmatin.homework07.service.library;

public interface LibraryService {

    void showBookById(long id);

    void showAllAvailableBooks();

    void showAllGenres();

    void showAllAuthors();

    void deleteBookById(long id);

    void addNewBook();

    void editBook();

    void showCommentsByBookId(long bookId);

    void addNewComment();

    void editComment();

    void deleteCommentById(long id);
}
