package ru.barmatin.homework18.util;

import ru.barmatin.homework18.domain.Book;
import ru.barmatin.homework18.domain.Genre;
import ru.barmatin.homework18.dto.BookDto;

import java.util.ArrayList;
import java.util.List;

public class MappingUtils {

    public static BookDto mapBookToDto(Book book, List<String> commentTextList) {
        String authorName = book.getAuthor().getSurname() + " " + book.getAuthor().getName() +
                (book.getAuthor().getPatronym().isEmpty() ? "" : " "+book.getAuthor().getPatronym());
        List<String> genreNameList = new ArrayList<>();
        for (Genre genre: book.getGenreList()) {
            genreNameList.add(genre.getName());
        }
        return new BookDto(book.getId(), book.getName(), authorName, genreNameList, commentTextList);
    }

}
