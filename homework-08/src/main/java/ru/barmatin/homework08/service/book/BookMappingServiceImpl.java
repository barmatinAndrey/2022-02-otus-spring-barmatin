package ru.barmatin.homework08.service.book;

import org.springframework.stereotype.Service;
import ru.barmatin.homework08.domain.Author;
import ru.barmatin.homework08.domain.Book;
import ru.barmatin.homework08.domain.Comment;
import ru.barmatin.homework08.domain.Genre;
import ru.barmatin.homework08.dto.BookDTO;
import ru.barmatin.homework08.dto.BookInputDTO;
import ru.barmatin.homework08.service.author.AuthorService;
import ru.barmatin.homework08.service.genre.GenreService;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookMappingServiceImpl implements BookMappingService {
    private final AuthorService authorService;
    private final GenreService genreService;

    public BookMappingServiceImpl(AuthorService authorService, GenreService genreService) {
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @Override
    public BookDTO mapBookToDTO(Book book, List<Comment> commentList) {
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
        return new BookDTO(book.getId(), book.getName(), authorName, genreNameList, commentTextList);
    }

    @Override
    public Book mapBookInput(BookInputDTO bookInputDTO) {
        Author author = authorService.getAuthorById(bookInputDTO.getAuthorId()).orElse(null);
        List<Genre> genreList = new ArrayList<>();
        for (String genreId: bookInputDTO.getGenreIdList()) {
            genreList.add(genreService.getGenreById(genreId).orElse(null));
        }
        return new Book(bookInputDTO.getId(), bookInputDTO.getName(), author, genreList);
    }

}
