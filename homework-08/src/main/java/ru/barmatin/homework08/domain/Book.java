package ru.barmatin.homework08.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
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
