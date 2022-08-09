package ru.barmatin.homework18.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.barmatin.homework18.domain.Author;
import ru.barmatin.homework18.domain.Book;
import ru.barmatin.homework18.domain.Genre;
import ru.barmatin.homework18.exception.NotFoundException;
import ru.barmatin.homework18.service.hystrix.HystrixCallService;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {
    private final HystrixCallService hystrixCallService;

    @Autowired
    public PageController(HystrixCallService hystrixCallService) {
        this.hystrixCallService = hystrixCallService;
    }

    @GetMapping("/")
    public String listPage() {
        return "list";
    }

    @GetMapping("/edit")
    public String editBook(@RequestParam("id") long id, Model model) {
        Book book = hystrixCallService.getBookById(id).orElseThrow(NotFoundException::new);
        List<Author> authorList = hystrixCallService.getAllAuthors();
        List<Genre> genreList = hystrixCallService.getAllGenres();
        model.addAttribute("book", book);
        model.addAttribute("authorList", authorList);
        model.addAttribute("genreList", genreList);
        return "edit";
    }

    @GetMapping("/new")
    public String addNewBook(Model model) {
        Author author = new Author(0, "", "", "");
        Book book = new Book(0, "", author, new ArrayList<>());
        List<Author> authorList = hystrixCallService.getAllAuthors();
        List<Genre> genreList = hystrixCallService.getAllGenres();
        model.addAttribute("book", book);
        model.addAttribute("authorList", authorList);
        model.addAttribute("genreList", genreList);
        return "edit";
    }

    @PostMapping("/edit")
    public String saveBook(Book book) {
        hystrixCallService.saveBook(book);
        return "redirect:/";
    }

}
