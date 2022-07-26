package ru.barmatin.homework18.controller.book;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.barmatin.homework18.dto.BookDto;
import ru.barmatin.homework18.service.book.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    }, fallbackMethod = "getFallbackBooksDto")
    @GetMapping("/api/book")
    public List<BookDto> getAllBooksDto() {
        sleepRandomly();
        return bookService.getAllAvailableBooksDto();
    }

    private List<BookDto> getFallbackBooksDto() {
        BookDto bookDto = new BookDto(0, "", "", new ArrayList<>(), new ArrayList<>());
        List<BookDto> bookDtoList = new ArrayList<>();
        bookDtoList.add(bookDto);
        return bookDtoList;
    }

    @DeleteMapping("/api/book/delete")
    public void deleteBook(@RequestParam("id") long id) {
        bookService.deleteBookById(id);
    }

    private void sleepRandomly() {
        Random rand = new Random();
        int randomNum = rand.nextInt(3) + 1;
        System.out.println(randomNum);
        if(randomNum == 3) {
            System.out.println("It is a chance for demonstrating Hystrix action");
            try {
                System.out.println("Start sleeping...." + System.currentTimeMillis());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Hystrix thread interupted...." + System.currentTimeMillis());
                e.printStackTrace();
            }
        }
    }

}
