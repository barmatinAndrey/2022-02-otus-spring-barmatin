package ru.barmatin.homework11.mapper;

import org.springframework.stereotype.Component;
import ru.barmatin.homework11.domain.Book;
import ru.barmatin.homework11.domain.Genre;
import ru.barmatin.homework11.dto.BookDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto mapBookToDto(Book book) {
        String authorName = book.getAuthor().getSurname() + " " + book.getAuthor().getName() +
                (book.getAuthor().getPatronym().isEmpty() ? "" : " "+book.getAuthor().getPatronym());
        List<String> genreNameList = new ArrayList<>();
        for (Genre genre: book.getGenreList()) {
            genreNameList.add(genre.getName());
        }
        return new BookDto(book.getId(), book.getName(), authorName, genreNameList);
    }
}
