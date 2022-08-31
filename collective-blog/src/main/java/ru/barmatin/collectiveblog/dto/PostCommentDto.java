package ru.barmatin.collectiveblog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostCommentDto {
    private long id;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm", timezone = "Asia/Novosibirsk")
    private Date postCommentDate;
    private String content;
    private long authorId;
    private String authorName;
}
