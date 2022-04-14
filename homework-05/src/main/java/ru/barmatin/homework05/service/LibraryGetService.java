package ru.barmatin.homework05.service;

public interface LibraryGetService {

    void showAllAvailableBooks();

    void showAllBooksByAuthorName(String textToSearch);

    void showAllBooksByBookName(String textToSearch);

    void showAllBooksByGenre(String genreName);

    void showAllGenres();

    void showAllAuthors();

}
