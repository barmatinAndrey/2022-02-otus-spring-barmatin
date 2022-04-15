package ru.barmatin.homework05.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.barmatin.homework05.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class AuthorDaoJdbc implements AuthorDao {
    private final NamedParameterJdbcOperations namedJdbc;

    public AuthorDaoJdbc(NamedParameterJdbcOperations namedJdbc) {
        this.namedJdbc = namedJdbc;
    }

    @Override
    public List<Author> getAll() {
        return namedJdbc.getJdbcOperations().query("select id, surname, name, patronym from authors order by surname", new AuthorMapper());
    }

    @Override
    public boolean exists(Author author) {
        Map<String,String> params = new HashMap<>(3);
        params.put("surname", author.getSurname());
        params.put("name", author.getName());
        params.put("patronym", author.getPatronym());
        long count = namedJdbc.queryForObject("select count(id) from authors where " +
                        "lower(surname) like lower(:surname) and " +
                        "lower(name) like lower(:name) and " +
                        "lower(patronym) like lower(:patronym)",
                    params, Long.class);
        return count!=0;
    }

    @Override
    public long getIdByName(Author author) {
        Map<String,String> params = new HashMap<>(3);
        params.put("surname", author.getSurname());
        params.put("name", author.getName());
        params.put("patronym", author.getPatronym());
        return namedJdbc.queryForObject("select id from authors where " +
                        "lower(surname) like lower(:surname) and " +
                        "lower(name) like lower(:name) and " +
                        "lower(patronym) like lower(:patronym)",
                    params, Long.class);
    }

    @Override
    public long getNextId() {
        return namedJdbc.getJdbcOperations().queryForObject("values next value for authors_sequence", Long.class);
    }

    @Override
    public void insert (Author author) {
        Map<String,Object> params = new HashMap<>(4);
        params.put("id", author.getId());
        params.put("surname", author.getSurname());
        params.put("name", author.getName());
        params.put("patronym", author.getPatronym());
        namedJdbc.update("insert into authors (id, surname, name, patronym) " +
                "values (:id, :surname, :name, :patronym)", params);
    }

    public static class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Author(
                    rs.getLong("id"),
                    rs.getString("surname"),
                    rs.getString("name"),
                    rs.getString("patronym")
                    );
        }
    }
}
