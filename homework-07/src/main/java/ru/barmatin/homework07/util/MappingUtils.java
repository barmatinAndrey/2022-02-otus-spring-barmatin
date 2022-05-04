package ru.barmatin.homework07.util;

import ru.barmatin.homework07.domain.Book;
import ru.barmatin.homework07.domain.Genre;
import ru.barmatin.homework07.dto.BookDTO;

import java.util.ArrayList;
import java.util.List;

public class MappingUtils {

    public static BookDTO mapBookToDTO(Book book, List<String> commentTextList) {
        String authorName = book.getAuthor().getSurname() + " " + book.getAuthor().getName() +
                (book.getAuthor().getPatronym().isEmpty() ? "" : " "+book.getAuthor().getPatronym());
        List<String> genreNameList = new ArrayList<>();
        for (Genre genre: book.getGenreList()) {
            genreNameList.add(genre.getName());
        }
        return new BookDTO(book.getId(), book.getName(), authorName, genreNameList, commentTextList);
    }

}
