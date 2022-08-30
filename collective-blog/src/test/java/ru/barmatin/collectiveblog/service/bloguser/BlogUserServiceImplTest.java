package ru.barmatin.collectiveblog.service.bloguser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.barmatin.collectiveblog.domain.BlogUser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({BlogUserServiceImpl.class})
class BlogUserServiceImplTest {

    @Autowired
    private BlogUserService blogUserService;

    @Test
    void getBlogUserByUsername() {
        BlogUser blogUser = blogUserService.getBlogUserByUsername("barmatin");
        assertThat(blogUser.getId()).isEqualTo(1);
    }

    @Test
    void saveBlogUser() {

    }
}