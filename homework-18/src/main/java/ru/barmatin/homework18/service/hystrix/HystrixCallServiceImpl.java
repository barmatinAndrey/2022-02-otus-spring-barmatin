package ru.barmatin.homework18.service.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework18.domain.Author;
import ru.barmatin.homework18.domain.Book;
import ru.barmatin.homework18.domain.Genre;
import ru.barmatin.homework18.dto.BookDto;
import ru.barmatin.homework18.service.author.AuthorService;
import ru.barmatin.homework18.service.book.BookService;
import ru.barmatin.homework18.service.genre.GenreService;
import ru.barmatin.homework18.service.threadsleepservice.ThreadSleepService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HystrixCallServiceImpl implements HystrixCallService {
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final ThreadSleepService threadSleepService;

    @Autowired
    public HystrixCallServiceImpl(BookService bookService, AuthorService authorService,
                                  GenreService genreService, ThreadSleepService threadSleepService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
        this.threadSleepService = threadSleepService;
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    }, fallbackMethod = "getFallbackBook")
    public Optional<Book> getBookById(long id) {
//        threadSleepService.sleepRandomly("getBookById");
        return bookService.getBookById(id);
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    }, fallbackMethod = "getFallbackBooksDto")
    @Override
    public List<BookDto> getAllBooksDto() {
//        threadSleepService.sleepRandomly("getAllBooksDto");
        return bookService.getAllAvailableBooksDto();
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    }, fallbackMethod = "callEmptyFallbackDelete")
    @Override
    public void deleteBook(long id) {
//        threadSleepService.sleepRandomly("deleteBook");
        bookService.deleteBookById(id);
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    }, fallbackMethod = "callEmptyFallbackSave")
    @Override
    public void saveBook(Book book) {
//        threadSleepService.sleepRandomly("saveBook");
        bookService.saveBook(book);
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    }, fallbackMethod = "getFallbackAuthors")
    @Override
    public List<Author> getAllAuthors() {
//        threadSleepService.sleepRandomly("getAllAuthors");
        return authorService.getAllAuthors();
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    }, fallbackMethod = "getFallbackGenres")
    @Override
    public List<Genre> getAllGenres() {
//        threadSleepService.sleepRandomly("getAllGenres");
        return genreService.getAllGenres();
    }

    private Optional<Book> getFallbackBook(long id) {
        return Optional.of(new Book(id, "N/A", new Author(0, "N/A", "N/A", "N/A"), new ArrayList<>()));
    }

    private List<BookDto> getFallbackBooksDto() {
        BookDto bookDto = new BookDto(0, "N/A", "N/A", new ArrayList<>());
        List<BookDto> bookDtoList = new ArrayList<>();
        bookDtoList.add(bookDto);
        return bookDtoList;
    }

    private List<Author> getFallbackAuthors() {
        return new ArrayList<>();
    }

    private List<Genre> getFallbackGenres() {
        return new ArrayList<>();
    }

    private void callEmptyFallbackDelete(long id) {

    }

    private void callEmptyFallbackSave(Book book) {

    }

}
