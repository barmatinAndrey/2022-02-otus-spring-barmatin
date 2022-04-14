package ru.barmatin.homework05.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.barmatin.homework05.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GenreDaoJdbc implements GenreDao {
    private final NamedParameterJdbcOperations namedJdbc;

    public GenreDaoJdbc(NamedParameterJdbcOperations namedJdbc) {
        this.namedJdbc = namedJdbc;
    }

    @Override
    public List<Genre> getAll() {
        return namedJdbc.getJdbcOperations().query("select id, name from genres order by name", new GenreMapper());
    }

    @Override
    public List<Genre> getAllUsed() {
        return namedJdbc.getJdbcOperations().query("select t.id, t.name from genres t " +
                "inner join books_genres t1 on (t.id = t1.genre_id) group by t.id, t.name", new GenreMapper());
    }

    @Override
    public List<Genre> getAllByName(String textToSearch) {
        Map<String, String> params = new HashMap<>(1);
        params.put("textToSearch", textToSearch);
        return namedJdbc.query("select id, name from genres " +
                "where lower(name) like lower('%'||:textToSearch||'%')", params, new GenreMapper());
    }

    @Override
    public long getCountByName(String name) {
        Map<String,String> params = new HashMap<>(1);
        params.put("name", name);
        return namedJdbc.queryForObject("select count(id) from genres where " +
                        "lower(name) like lower('%'||:name||'%')",
                params, Long.class);
    }

    @Override
    public long getIdByName(String name) {
        Map<String,String> params = new HashMap<>(1);
        params.put("name", name);
        return namedJdbc.queryForObject("select id from genres where " +
                        "lower(name) like lower('%'||:name||'%')",
                params, Long.class);
    }

    @Override
    public long count() {
        return namedJdbc.getJdbcOperations().queryForObject("select count(id) from genres", Long.class);
    }

    @Override
    public void insert (Genre genre) {
        Map<String,Object> params = new HashMap<>(2);
        params.put("id", genre.getId());
        params.put("name", genre.getName());
        namedJdbc.update("insert into genres (id, name) " +
                "values (:id, :name)", params);
    }

    public static class GenreMapper implements RowMapper<Genre>{

        @Override
        public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Genre(rs.getLong("id"), rs.getString("name"));
        }
    }

}
