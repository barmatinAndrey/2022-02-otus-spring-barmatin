package ru.barmatin.homework13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.barmatin.homework13.domain.Author;
import ru.barmatin.homework13.domain.Book;
import ru.barmatin.homework13.domain.Genre;
import ru.barmatin.homework13.dto.BookDto;
import ru.barmatin.homework13.exception.NotFoundException;
import ru.barmatin.homework13.service.author.AuthorService;
import ru.barmatin.homework13.service.book.BookService;
import ru.barmatin.homework13.service.genre.GenreService;

import java.util.ArrayList;
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
        return "redirect:/";
    }

    @DeleteMapping("/delete")
    public String deleteBook(@RequestParam("id") long id) {
        bookService.deleteBookById(id);
        return "redirect:/";
    }

    @ExceptionHandler(NotFoundException.class)
    public String handleException(Model model) {
        model.addAttribute("status", "Такой книги в библиотеке нет.");
        return "error";
    }

}
