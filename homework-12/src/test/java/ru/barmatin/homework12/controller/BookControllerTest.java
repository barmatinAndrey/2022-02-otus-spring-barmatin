package ru.barmatin.homework12.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.barmatin.homework12.security.UserDetailsServiceImpl;
import ru.barmatin.homework12.service.author.AuthorService;
import ru.barmatin.homework12.service.book.BookService;
import ru.barmatin.homework12.service.genre.GenreService;
import ru.barmatin.homework12.service.user.LibraryUserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
@Import(UserDetailsServiceImpl.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @MockBean
    private AuthorService authorService;

    @MockBean
    private GenreService genreService;

    @MockBean
    private LibraryUserService libraryUserService;


    @WithMockUser(authorities = {"USER"})
    @Test
    void listPage() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    void editBook() throws Exception {
        mockMvc.perform(get("/edit")).andExpect(status().is3xxRedirection());
    }

    @Test
    void addNewBook() throws Exception {
        mockMvc.perform(get("/new")).andExpect(status().is3xxRedirection());
    }

}