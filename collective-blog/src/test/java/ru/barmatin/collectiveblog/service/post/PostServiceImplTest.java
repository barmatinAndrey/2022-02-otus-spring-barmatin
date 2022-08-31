package ru.barmatin.collectiveblog.service.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.barmatin.collectiveblog.domain.BlogUser;
import ru.barmatin.collectiveblog.domain.Post;
import ru.barmatin.collectiveblog.domain.PostCategory;
import ru.barmatin.collectiveblog.service.bloguser.BlogUserService;
import ru.barmatin.collectiveblog.service.bloguser.BlogUserServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({BlogUserServiceImpl.class, PostServiceImpl.class})
class PostServiceImplTest {

    @Autowired
    private PostService postService;

    @Autowired
    private TestEntityManager em;

    @Test
    void getAllByVisibility() {
        List<Post> postList = postService.getAllByVisibility(true);
        assertThat(postList).hasSize(1).extracting(Post::isVisible).containsExactly(true);
    }

    @Test
    void getAllByPostCategoryId() {
        List<Post> postList = postService.getAllByPostCategoryId(6L, true);
        assertThat(postList).hasSize(1).extracting(Post::getId).containsExactly(1L);
    }

    @Test
    void getAllByTagName() {
        List<Post> postList = postService.getAllByTagName("Африка", true);
        assertThat(postList).hasSize(1).extracting(Post::getId).containsExactly(1L);
    }

    @Test
    void getAllByBlogUserId() {
        List<Post> postList = postService.getAllByBlogUserId(1);
        assertThat(postList).hasSize(2).extracting(Post::getId).containsExactlyInAnyOrder(1L, 2L);
    }

    @Test
    void getById() {
        Post post = postService.getById(1);
        assertThat(post.getTitle()).isEqualTo("Как бельгийский король Леопольд II уничтожил 10 миллионов африканцев");
    }

    @Test
    void savePost() {
        BlogUser blogUser = em.find(BlogUser.class, 1L);
        PostCategory postCategory = em.find(PostCategory.class, 1L);
        Post post = new Post(0, blogUser, postCategory, "title", "content", new Date(), new ArrayList<>(), true);
        postService.savePost(post);
        Post post1 = postService.getById(3);
        assertThat(post).isEqualTo(post1);
    }

    @Test
    void deletePostById() {
        Post post = em.find(Post.class, 1L);
        assertThat(post).isNotNull();
        postService.deletePostById(post.getId());
        Post post1 = em.find(Post.class, 1L);
        assertThat(post1).isNull();
    }
}