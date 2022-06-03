package ru.barmatin.homework11.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String name;
    private Author author;
    private List<Genre> genreList;

    public Book(String name, Author author, List<Genre> genreList) {
        this.name = name;
        this.author = author;
        this.genreList = genreList;
    }
}
