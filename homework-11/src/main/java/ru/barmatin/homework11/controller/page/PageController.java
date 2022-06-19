package ru.barmatin.homework11.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @GetMapping("/")
    public String listPage() {
        return "list";
    }

    @GetMapping("/book/edit")
    public String editBook(@RequestParam("id") String id) {
        return "edit";
    }

    @GetMapping("/book/add")
    public String addBook() {;
        return "edit";
    }

}
