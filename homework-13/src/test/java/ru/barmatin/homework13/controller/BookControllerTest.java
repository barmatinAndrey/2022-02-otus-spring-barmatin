package ru.barmatin.homework13.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.barmatin.homework13.exception.NotFoundException;
import ru.barmatin.homework13.security.UserDetailsServiceImpl;
import ru.barmatin.homework13.service.author.AuthorService;
import ru.barmatin.homework13.service.book.BookService;
import ru.barmatin.homework13.service.genre.GenreService;
import ru.barmatin.homework13.service.user.LibraryUserService;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @Test
    void listPage() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().is3xxRedirection());
    }

    @WithMockUser
    @Test
    void listPageAuthenticated() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @WithMockUser(authorities = {"ROLE_USER"})
    @Test
    void addNewBookUser() throws Exception {
        mockMvc.perform(get("/new")).andExpect(status().isForbidden());
    }

    @WithMockUser(authorities = {"ROLE_ADMIN"})
    @Test
    void addNewBookAdmin() throws Exception {
        mockMvc.perform(get("/new")).andExpect(status().isOk());
    }

    @WithMockUser(authorities = {"ROLE_USER"})
    @Test
    void editBookUser() throws Exception {
        mockMvc.perform(get("/edit")
                .param("id", "1"))
                .andExpect(status().isForbidden());
    }

    @WithMockUser(authorities = {"ROLE_ADMIN"})
    @Test
    void editBookAdmin() throws Exception {
        mockMvc.perform(get("/edit")
                .param("id", "1"))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof NotFoundException));
    }

    @WithMockUser(authorities = {"ROLE_USER"})
    @Test
    void postBookUser() throws Exception {
        mockMvc.perform(post("/edit"))
                .andExpect(status().isForbidden());
    }

    @WithMockUser(authorities = {"ROLE_ADMIN"})
    @Test
    void postBookAdmin() throws Exception {
        mockMvc.perform(post("/edit")
                .with(csrf()))
                .andExpect(status().is3xxRedirection());
    }

    @WithMockUser(authorities = {"ROLE_USER"})
    @Test
    void deleteBookUser() throws Exception {
        mockMvc.perform(delete("/delete")
                .param("id", "1")
                .with(csrf()))
                .andExpect(status().isForbidden());
    }

    @WithMockUser(authorities = {"ROLE_ADMIN"})
    @Test
    void deleteBookAdmin() throws Exception {
        mockMvc.perform(delete("/delete")
                .param("id", "1")
                .with(csrf()))
                .andExpect(status().is3xxRedirection());
    }

}