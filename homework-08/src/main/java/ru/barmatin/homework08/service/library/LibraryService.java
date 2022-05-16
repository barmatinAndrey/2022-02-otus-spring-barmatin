package ru.barmatin.homework08.service.library;

public interface LibraryService {

    void showBookById(String id);

    void showAllAvailableBooks();

    void showAllGenres();

    void showAllAuthors();

    void deleteBookById(String id);

    void addNewBook();

    void editBook();

    void addNewComment();

    void editComment();

    void deleteCommentById(String id);
}
