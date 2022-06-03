package ru.barmatin.homework11.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
