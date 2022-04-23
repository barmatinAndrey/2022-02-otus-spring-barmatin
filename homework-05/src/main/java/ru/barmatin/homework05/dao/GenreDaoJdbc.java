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
    public List<Genre> getAllByBookId(long bookId) {
        Map<String, Long> params = new HashMap<>(1);
        params.put("bookId", bookId);
        return namedJdbc.query("select t.id, t.name from genres t " +
                "inner join books_genres t1 on (t.id = t1.genre_id and t1.book_id = :bookId) group by t.id, t.name", params, new GenreMapper());
    }

    public static class GenreMapper implements RowMapper<Genre>{

        @Override
        public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Genre(rs.getLong("id"), rs.getString("name"));
        }
    }

}
