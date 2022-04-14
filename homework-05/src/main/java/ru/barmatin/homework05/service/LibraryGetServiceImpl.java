package ru.barmatin.homework05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework05.dao.AuthorDao;
import ru.barmatin.homework05.dao.BookDao;
import ru.barmatin.homework05.dao.GenreDao;
import ru.barmatin.homework05.domain.Author;
import ru.barmatin.homework05.domain.Book;
import ru.barmatin.homework05.domain.Genre;

import java.util.List;

@Service
public class LibraryGetServiceImpl implements LibraryGetService {
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;
    private final OutputService outputService;

    @Autowired
    public LibraryGetServiceImpl(BookDao bookDao, AuthorDao authorDao, GenreDao genreDao, OutputService outputService) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.genreDao = genreDao;
        this.outputService = outputService;
    }

    @Override
    public void showAllAvailableBooks() {
        outputBookList(bookDao.getAll());
    }

    @Override
    public void showAllBooksByAuthorName(String textToSearch) {
        outputBookList(bookDao.getAllByAuthorName(textToSearch));
    }

    @Override
    public void showAllBooksByBookName(String textToSearch) {
        outputBookList(bookDao.getAllByBookName(textToSearch));
    }

    @Override
    public void showAllBooksByGenre(String genreName) {
        outputBookList(bookDao.getAllByGenre(genreName));
    }

    @Override
    public void showAllGenres() {
        outputGenreList(genreDao.getAll());
    }

    @Override
    public void showAllAuthors() {
        outputAuthorList(authorDao.getAll());
    }

    private void outputBookList(List<Book> bookList) {
        for (int i=0; i<bookList.size(); i++) {
            String outputBook = (i+1) + ". " + bookList.get(i).getName();
            String outputAuthor = bookList.get(i).getAuthor().getSurname() + " " + bookList.get(i).getAuthor().getName() +
                    (bookList.get(i).getAuthor().getPatronym().isEmpty() ? "" : " "+bookList.get(i).getAuthor().getPatronym());
            List<Genre> genreList = bookList.get(i).getGenreList();
            StringBuilder outputGenresBuilder = new StringBuilder();
            outputGenresBuilder.append("(");
            for (int j = 0; j<genreList.size(); j++) {
                outputGenresBuilder.append(genreList.get(j).getName());
                outputGenresBuilder.append((j == genreList.size() - 1) ? "" : ", ");
            }
            outputGenresBuilder.append(") (id=");
            outputGenresBuilder.append(bookList.get(i).getId());
            outputGenresBuilder.append(")");
            String outputGenres = outputGenresBuilder.toString();
            outputService.outputStringLn(outputBook + " - " + outputAuthor + " "+ outputGenres);
            outputService.outputStringLn("-------------------------------------------------------------------");
        }
    }

    private void outputGenreList(List<Genre> genreList) {
        for (int i=0; i<genreList.size(); i++) {
            outputService.outputStringLn((i+1) +". "+ genreList.get(i).getName());
        }
    }

    private void outputAuthorList(List<Author> authorList) {
        for (int i=0; i<authorList.size(); i++) {
            outputService.outputStringLn((i+1) +". "+ authorList.get(i).getSurname() +" "+ authorList.get(i).getName() +" "+ authorList.get(i).getPatronym());
        }
    }

}
