package ru.barmatin.collectiveblog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = BlogUser.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_user_id")
    private BlogUser blogUser;

    @ManyToOne(targetEntity = PostCategory.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_category_id")
    private PostCategory postCategory;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "post_date")
    private String postDate;

    @Column(name = "is_visible")
    private boolean isVisible;

}
