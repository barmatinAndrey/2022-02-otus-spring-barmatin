package ru.barmatin.collectiveblog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm", timezone = "Asia/Novosibirsk")
    private Date postDate;

    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany(targetEntity = PostTag.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "posts_tags", joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<PostTag> postTagList;

    @Column(name = "is_visible")
    private boolean isVisible;

}
