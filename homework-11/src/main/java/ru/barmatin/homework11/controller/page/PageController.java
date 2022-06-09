package ru.barmatin.homework11.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.barmatin.homework11.domain.Author;
import ru.barmatin.homework11.domain.Book;
import ru.barmatin.homework11.repository.AuthorRepository;
import ru.barmatin.homework11.repository.BookRepository;
import ru.barmatin.homework11.repository.GenreRepository;

import java.util.ArrayList;

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

    @GetMapping("/book/edit")
    public String editBook(@RequestParam("id") String id) {
        return "edit";
    }

    @GetMapping("/book/add")
    public String addBook(Model model) {
        Author author = new Author("", "", "");
        Mono<Book> book = Mono.just(new Book("", author, new ArrayList<>()));
        model.addAttribute("book", book);
        model.addAttribute("authorList",authorRepository.findAll(Sort.by("surname")));
        model.addAttribute("genreList", genreRepository.findAll(Sort.by("genre")));
        return "edit";
    }

//    @PostMapping("/book/edit")
//    public String saveBook(Mono<Book> bookMono) {
//        bookMono.map(book -> {
//            if (book.getId().isEmpty()) {
//                book.setId(null);
//            }
//            bookRepository.save(book);
//            return "redirect:/";
//        }).subscribe();
//        return "redirect:/";
//    }
////В этом методе возвращается MonoError: org.springframework.web.bind.support.WebExchangeBindException:
//// Validation failed for argument at index 0 in method:
//// public java.lang.String ru.barmatin.homework11.controller.page.PageController.saveBook
//// (reactor.core.publisher.Mono<ru.barmatin.homework11.domain.Book>), with 1 error(s):
//// [Field error in object 'bookMono' on field 'author': rejected value
//// [Author(id=629cc7727d2fd0422803f552, surname=Маркес, name=Габриэль Гарсия, patronym=)];
//// codes [typeMismatch.bookMono.author,typeMismatch.author,typeMismatch.ru.barmatin.homework11.domain.Author,typeMismatch];
//// arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [bookMono.author,author]; arguments [];
//// default message [author]]; default message [Failed to convert property value of type 'java.lang.String' to required type
//// 'ru.barmatin.homework11.domain.Author' for property 'author'; nested exception is java.lang.IllegalStateException:
//// Cannot convert value of type 'java.lang.String' to required type 'ru.barmatin.homework11.domain.Author' for property 'author':
//// no matching editors or conversion strategy found]]

}
