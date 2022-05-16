package ru.barmatin.homework08.service.book;

import ru.barmatin.homework08.domain.Book;
import ru.barmatin.homework08.domain.Comment;
import ru.barmatin.homework08.dto.BookDTO;
import ru.barmatin.homework08.dto.BookInputDTO;

import java.util.List;

public interface BookMappingService {

    BookDTO mapBookToDTO(Book book, List<Comment> commentList);

    Book mapBookInput(BookInputDTO bookInputDTO);
}
