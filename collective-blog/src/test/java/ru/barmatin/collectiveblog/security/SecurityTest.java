package ru.barmatin.collectiveblog.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.barmatin.collectiveblog.controller.PageController;
import ru.barmatin.collectiveblog.controller.rest.PostController;
import ru.barmatin.collectiveblog.service.bloguser.BlogUserService;
import ru.barmatin.collectiveblog.service.post.PostService;
import ru.barmatin.collectiveblog.service.posttag.PostTagService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@WebMvcTest({PostController.class, PageController.class})
@Import({UserDetailsServiceImpl.class, SpringSecurityConfig.class})
class SecurityTest {

    @MockBean
    private BlogUserService blogUserService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @MockBean
    private PostTagService postTagService;

    @Test
    void editPage() throws Exception {
        mockMvc.perform(get("/post-edit/new")).andExpect(status().is3xxRedirection());
    }

    @WithMockUser(authorities = {"ADMIN", "USER"})
    @Test
    void editPageUser() throws Exception {
        mockMvc.perform(get("/post-edit/new")).andExpect(status().isOk());
    }

}