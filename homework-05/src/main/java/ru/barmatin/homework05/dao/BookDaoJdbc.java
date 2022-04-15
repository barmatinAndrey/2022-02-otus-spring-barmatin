package ru.barmatin.homework05.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.barmatin.homework05.dao.ext.BookGenreRelation;
import ru.barmatin.homework05.domain.Author;
import ru.barmatin.homework05.domain.Book;
import ru.barmatin.homework05.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class BookDaoJdbc implements BookDao {
    private final NamedParameterJdbcOperations namedJdbc;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;

    @Autowired
    public BookDaoJdbc(NamedParameterJdbcOperations namedJdbc, AuthorDao authorDao, GenreDao genreDao) {
        this.namedJdbc = namedJdbc;
        this.authorDao = authorDao;
        this.genreDao = genreDao;
    }

    @Override
    public List<Book> getAll() {
        List<Book> bookList = namedJdbc.getJdbcOperations().query("select t.id as book_id, t.name as book_name, t1.id as author_id, " +
                "t1.surname as author_surname, t1.name as author_name, t1.patronym as author_patronym from books t " +
                "left join authors t1 on (t.author_id =t1.id) order by t.name", new BookMapper());
        List<Genre> genreList = genreDao.getAllUsed();
        List<BookGenreRelation> bookGenreRelationList = getAllRelations();
        mergedBooksGenresList(bookList, genreList, bookGenreRelationList);
        return bookList;
    }

    @Override
    public List<Book> getAllByAuthorNameContains(String text) {
        Map<String, String> params = new HashMap<>(1);
        params.put("text", text);
        List<Book> bookList = namedJdbc.query("select t.id as book_id, t.name as book_name, t1.id as author_id, " +
                "t1.surname as author_surname, t1.name as author_name, t1.patronym as author_patronym from books t " +
                "left join authors t1 on (t.author_id =t1.id) " +
                "where lower(t1.surname) like lower('%'||:text||'%') " +
                "or lower(t1.name) like lower('%'||:text||'%') " +
                "or lower(t1.patronym) like lower('%'||:text||'%') " +
                "order by t.name", params, new BookMapper());
        List<Genre> genreList = genreDao.getAllUsed();
        List<BookGenreRelation> bookGenreRelationList = getAllRelations();
        mergedBooksGenresList(bookList, genreList, bookGenreRelationList);
        return bookList;
    }

    @Override
    public List<Book> getAllByBookNameContains(String text) {
        Map<String, String> params = new HashMap<>(1);
        params.put("text", text);
        List<Book> bookList = namedJdbc.query("select t.id as book_id, t.name as book_name, t1.id as author_id, " +
                "t1.surname as author_surname, t1.name as author_name, t1.patronym as author_patronym from books t " +
                "left join authors t1 on (t.author_id =t1.id) " +
                "where lower(t.name) like lower('%'||:text||'%') " +
                "order by t.name", params, new BookMapper());
        List<Genre> genreList = genreDao.getAllUsed();
        List<BookGenreRelation> bookGenreRelationList = getAllRelations();
        mergedBooksGenresList(bookList, genreList, bookGenreRelationList);
        return bookList;
    }

    @Override
    public List<Book> getAllByGenreNameContains(String text) {
        Map<String, String> params = new HashMap<>(1);
        params.put("text", text);
        List<Book> bookList = namedJdbc.query("select t.id as book_id, t.name as book_name, t1.id as author_id, " +
                "t1.surname as author_surname, t1.name as author_name, t1.patronym as author_patronym from books t " +
                "left join authors t1 on (t.author_id =t1.id) " +
                "left join books_genres t2 on (t.id = t2.book_id) " +
                "left join genres t3 on (t3.id=t2.genre_id) " +
                "where lower(t3.name) like lower('%'||:text||'%') group by t.id, t.name order by t.name",
                params, new BookMapper());
        List<Genre> genreList = genreDao.getAllByName(text);
        List<BookGenreRelation> bookGenreRelationList = getAllRelations();
        mergedBooksGenresList(bookList, genreList, bookGenreRelationList);
        return bookList;
    }

    private List<BookGenreRelation> getAllRelations() {
        return namedJdbc.getJdbcOperations().query("select book_id, genre_id from books_genres order by book_id, genre_id",
                (rs, rowNum) -> new BookGenreRelation(rs.getLong("book_id"), rs.getLong("genre_id")));
    }

    @Override
    public void deleteById(long id) {
        Map<String, Long> params = new HashMap<>(1);
        params.put("id", id);
        namedJdbc.update("delete from books where id = :id", params);
    }

    @Override
    public long getNextId() {
        return namedJdbc.getJdbcOperations().queryForObject("values next value for books_sequence", Long.class);
    }

    @Override
    public void insert(Book book) {
        book.setId(getNextId());
        checkAuthor(book);
        checkGenreList(book);
        Map<String,Object> params = new HashMap<>(3);
        params.put("id", book.getId());
        params.put("name", book.getName());
        params.put("authorId", book.getAuthor().getId());
        namedJdbc.update("insert into books (id, name, author_id) " +
                "values (:id, :name, :authorId)", params);
        for (Genre genre: book.getGenreList()) {
            insert(new BookGenreRelation(book.getId(), genre.getId()));
        }
    }

    private void checkAuthor(Book book) {
        if (!authorDao.exists(book.getAuthor())) {
            long authorId = authorDao.getNextId();
            book.getAuthor().setId(authorId);
            authorDao.insert(book.getAuthor());
        }
        else {
            long authorId = authorDao.getIdByName(book.getAuthor());
            book.getAuthor().setId(authorId);
        }
    }

    private void checkGenreList(Book book) {
        for (Genre genre: book.getGenreList()) {
            if (!genreDao.exists(genre)) {
                long genreId = genreDao.getNextId();
                genre.setId(genreId);
                genreDao.insert(genre);
            }
            else {
                long genreId = genreDao.getIdByName(genre);
                genre.setId(genreId);
            }
        }
    }

    private void insert(BookGenreRelation bookGenreRelation) {
        Map<String,Object> params = new HashMap<>(2);
        params.put("bookId", bookGenreRelation.getBookId());
        params.put("genreId", bookGenreRelation.getGenreId());
        namedJdbc.update("insert into books_genres (book_id, genre_id) " +
                "values (:bookId, :genreId)", params);
    }

    public static class BookMapper implements RowMapper<Book>{

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            long bookId = rs.getLong("book_id");
            String bookName = rs.getString("book_name");
            long authorId = rs.getLong("author_id");
            String authorSurname = rs.getString("author_surname");
            String authorName = rs.getString("author_name");
            String authorPatronym = rs.getString("author_patronym");
            Author author = new Author(authorId, authorSurname, authorName, authorPatronym);
            return new Book(bookId, bookName, author, new ArrayList<>());
        }
    }

    private void mergedBooksGenresList(List<Book> bookList, List<Genre> genreList, List<BookGenreRelation> bookGenreRelationList) {
        Map<Long, List<Genre>> bookMap = bookList.stream().collect(Collectors.toMap(Book::getId, Book::getGenreList));
        Map<Long, Genre> genreMap = genreList.stream().collect(Collectors.toMap(Genre::getId, Function.identity()));
        bookGenreRelationList.forEach(relation -> {
            if (bookMap.containsKey(relation.getBookId()) && genreMap.containsKey(relation.getGenreId())) {
                bookMap.get(relation.getBookId()).add(genreMap.get(relation.getGenreId()));
            }
        });
    }
}
