package ru.barmatin.homework09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.barmatin.homework09.domain.Genre;
import ru.barmatin.homework09.dto.AuthorDto;
import ru.barmatin.homework09.dto.BookDto;
import ru.barmatin.homework09.service.author.AuthorService;
import ru.barmatin.homework09.service.book.BookService;
import ru.barmatin.homework09.service.genre.GenreService;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService, GenreService genreService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @GetMapping("/")
    public String listPage(Model model) {
        List<BookDto> bookDtoList = bookService.getAllAvailableBooksDto();
        model.addAttribute("bookDtoList", bookDtoList);
        return "list";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") int id, Model model) {
        BookDto bookDto = bookService.getBookDtoById(id);
        List<AuthorDto> authorDtoList = authorService.getAllAuthorsDto();
        List<Genre> genreList = genreService.getAllGenres();
        model.addAttribute("bookDto", bookDto);
        model.addAttribute("authorDtoList", authorDtoList);
        model.addAttribute("genreList", genreList);
        return "edit";
    }

}
