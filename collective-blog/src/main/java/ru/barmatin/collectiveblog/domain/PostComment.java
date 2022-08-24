package ru.barmatin.collectiveblog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "post_comments")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = Post.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(targetEntity = BlogUser.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_user_id")
    private BlogUser blogUser;

    @Column(name = "post_comment_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm", timezone = "Asia/Novosibirsk")
    private Date postCommentDate;

    @Column(name = "content")
    private String content;
}