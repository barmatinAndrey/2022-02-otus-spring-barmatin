package ru.barmatin.homework12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.barmatin.homework12.domain.Author;
import ru.barmatin.homework12.domain.Book;
import ru.barmatin.homework12.domain.Genre;
import ru.barmatin.homework12.dto.BookDto;
import ru.barmatin.homework12.exception.NotFoundException;
import ru.barmatin.homework12.service.author.AuthorService;
import ru.barmatin.homework12.service.book.BookService;
import ru.barmatin.homework12.service.genre.GenreService;

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
    public String editPage(@RequestParam("id") long id, Model model) {
        Book book;
        if (id!=0) {
            book = bookService.getBookById(id).orElseThrow(NotFoundException::new);
        }
        else {
            Author author = new Author(0, "", "", "");
            book = new Book(0, "", author, new ArrayList<>());
        }
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

    @RequestMapping("/delete")
    public String deleteBook(@RequestParam("id") long id) {
        bookService.deleteBookById(id);
        return "redirect:/";
    }

}
