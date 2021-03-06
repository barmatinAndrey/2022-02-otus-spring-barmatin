package ru.barmatin.homework08.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Document(collection = "authors")
public class Author {
    @Id
    private String id;
    private String surname;
    private String name;
    private String patronym;

    public Author(String surname, String name, String patronym) {
        this.surname = surname;
        this.name = name;
        this.patronym = patronym;
    }

}
