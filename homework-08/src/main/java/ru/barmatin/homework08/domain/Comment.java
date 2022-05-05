package ru.barmatin.homework08.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Document(collection = "comments")
public class Comment {
    @Id
    private String id;
    private String bookId;
    private String text;

    public Comment(String bookId, String text){
        this.bookId = bookId;
        this.text = text;
    }
}
