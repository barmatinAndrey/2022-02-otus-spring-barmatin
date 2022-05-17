package ru.barmatin.homework09.service.library;

public interface LibraryService {

//    void showBookById(long id);
//
//    void showAllAvailableBooks();

    void showAllGenres();

    void showAllAuthors();

    void deleteBookById(long id);

    void addNewBook();

    void editBook();

    void addNewComment();

    void editComment();

    void deleteCommentById(long id);
}
