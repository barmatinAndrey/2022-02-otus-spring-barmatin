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
    private final GenreDao genreDao;

    @Autowired
    public BookDaoJdbc(NamedParameterJdbcOperations namedJdbc, GenreDao genreDao) {
        this.namedJdbc = namedJdbc;
        this.genreDao = genreDao;
    }

    @Override
    public Book getBookById(long id) {
        Map<String, Long> params = new HashMap<>(1);
        params.put("id", id);
        Book book = namedJdbc.queryForObject("select t.id as book_id, t.name as book_name, t1.id as author_id, " +
                "t1.surname as author_surname, t1.name as author_name, t1.patronym as author_patronym from books t " +
                "left join authors t1 on (t.author_id =t1.id) where t.id = :id", params, new BookMapper());
        List<Genre> genreList = genreDao.getAllByBookId(id);
        if (book != null) {
            book.setGenreList(genreList);
        }
        return book;
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

    private long getNextId() {
        return namedJdbc.getJdbcOperations().queryForObject("values next value for books_sequence", Long.class);
    }

    @Override
    public void insert(Book book) {
        book.setId(getNextId());
        Map<String,Object> params = new HashMap<>(3);
        params.put("id", book.getId());
        params.put("name", book.getName());
        params.put("authorId", book.getAuthor().getId());
        namedJdbc.update("insert into books (id, name, author_id) " +
                "values (:id, :name, :authorId)", params);
        for (Genre genre: book.getGenreList()) {
            insertBookGenreRelations(new BookGenreRelation(book.getId(), genre.getId()));
        }
    }

    @Override
    public void update(Book book) {
        Map<String,Object> params = new HashMap<>(3);
        params.put("id", book.getId());
        params.put("name", book.getName());
        params.put("authorId", book.getAuthor().getId());
        namedJdbc.update("update books set name = :name, author_id = :authorId where id = :id", params);
        deleteBookGenreRelationsByBookId(book.getId());
        for (Genre genre: book.getGenreList()) {
            insertBookGenreRelations(new BookGenreRelation(book.getId(), genre.getId()));
        }
    }

    private void insertBookGenreRelations(BookGenreRelation bookGenreRelation) {
        Map<String,Object> params = new HashMap<>(2);
        params.put("bookId", bookGenreRelation.getBookId());
        params.put("genreId", bookGenreRelation.getGenreId());
        namedJdbc.update("insert into books_genres (book_id, genre_id) " +
                "values (:bookId, :genreId)", params);
    }

    private void deleteBookGenreRelationsByBookId(long bookId) {
        Map<String,Object> params = new HashMap<>(1);
        params.put("bookId", bookId);
        namedJdbc.update("delete from books_genres where book_id = :bookId", params);
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
