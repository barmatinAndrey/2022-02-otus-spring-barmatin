package ru.barmatin.homework16.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.barmatin.homework16.actuator.CustomMetric;
import ru.barmatin.homework16.domain.Author;
import ru.barmatin.homework16.domain.Book;
import ru.barmatin.homework16.domain.Genre;
import ru.barmatin.homework16.exception.NotFoundException;
import ru.barmatin.homework16.service.author.AuthorService;
import ru.barmatin.homework16.service.book.BookService;
import ru.barmatin.homework16.service.genre.GenreService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final CustomMetric customMetric;

    @Autowired
    public PageController(BookService bookService, AuthorService authorService, GenreService genreService, CustomMetric customMetric) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
        this.customMetric = customMetric;
    }

    @GetMapping("/")
    public String listPage() {
        return "list";
    }

    @GetMapping("/edit")
    public String editBook(@RequestParam("id") long id, Model model) {
        Book book = bookService.getBookById(id).orElseThrow(NotFoundException::new);
        List<Author> authorList = authorService.getAllAuthors();
        List<Genre> genreList = genreService.getAllGenres();
        model.addAttribute("book", book);
        model.addAttribute("authorList", authorList);
        model.addAttribute("genreList", genreList);
        return "edit";
    }

    @GetMapping("/new")
    public String addNewBook(Model model) {
        Author author = new Author(0, "", "", "");
        Book book = new Book(0, "", author, new ArrayList<>());
        List<Author> authorList = authorService.getAllAuthors();
        List<Genre> genreList = genreService.getAllGenres();
        model.addAttribute("book", book);
        model.addAttribute("authorList", authorList);
        model.addAttribute("genreList", genreList);
        return "edit";
    }

    @PostMapping("/edit")
    public String saveBook(Book book) {
        bookService.saveBook(book);
        customMetric.incrementAddBookCounter();
        return "redirect:/";
    }

}
