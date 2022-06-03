package ru.barmatin.homework11.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.barmatin.homework11.domain.Author;
import ru.barmatin.homework11.domain.Book;
import ru.barmatin.homework11.domain.Genre;
import ru.barmatin.homework11.exception.NotFoundException;
import ru.barmatin.homework11.repository.AuthorRepository;
import ru.barmatin.homework11.repository.BookRepository;
import ru.barmatin.homework11.repository.GenreRepository;


import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public PageController(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping("/")
    public String listPage() {
        return "list";
    }

//    @GetMapping("/book/edit")
//    public String editBook(@RequestParam("id") String id, Model model) {
//        Book book = bookService.getBookById(id).orElseThrow(NotFoundException::new);
//        List<Author> authorList = authorService.getAllAuthors();
//        List<Genre> genreList = genreService.getAllGenres();
//        model.addAttribute("book", book);
//        model.addAttribute("authorList", authorList);
//        model.addAttribute("genreList", genreList);
//        return "edit";
//    }
//
//    @GetMapping("/book/add")
//    public String addBook(Model model) {
//        Author author = new Author("", "", "");
//        Book book = new Book("", author, new ArrayList<>());
//        List<Author> authorList = authorService.getAllAuthors();
//        List<Genre> genreList = genreService.getAllGenres();
//        model.addAttribute("book", book);
//        model.addAttribute("authorList", authorList);
//        model.addAttribute("genreList", genreList);
//        return "edit";
//    }

//    @PostMapping("/book/edit")
//    public String saveBook(Book book) {
//        if (book.getId().isEmpty()) {
//            book.setId(null);
//        }
//        bookService.saveBook(book);
//        return "redirect:/";
//    }

}
