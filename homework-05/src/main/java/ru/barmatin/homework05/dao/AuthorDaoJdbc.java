package ru.barmatin.homework05.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.barmatin.homework05.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


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
