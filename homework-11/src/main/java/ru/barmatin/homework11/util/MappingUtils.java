package ru.barmatin.homework11.util;

import ru.barmatin.homework11.domain.Book;
import ru.barmatin.homework11.domain.Comment;
import ru.barmatin.homework11.domain.Genre;
import ru.barmatin.homework11.dto.BookDto;

import java.util.ArrayList;
import java.util.List;

public class MappingUtils {

    public static BookDto mapBookToDto(Book book, List<Comment> commentList) {
        String authorName = book.getAuthor().getSurname() + " " + book.getAuthor().getName() +
                (book.getAuthor().getPatronym().isEmpty() ? "" : " "+book.getAuthor().getPatronym());
        List<String> genreNameList = new ArrayList<>();
        for (Genre genre: book.getGenreList()) {
            genreNameList.add(genre.getName());
        }
        List<String> commentTextList = new ArrayList<>();
        for (Comment comment: commentList) {
            commentTextList.add(comment.getText());
        }
        return new BookDto(book.getId(), book.getName(), authorName, genreNameList, commentTextList);
    }

}
