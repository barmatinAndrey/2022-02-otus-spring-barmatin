package ru.barmatin.homework14.domain.mongo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Document(collection = "authors")
public class AuthorMongo {
    @Id
    private String id;
    private String surname;
    private String name;
    private String patronym;

    public AuthorMongo(String surname, String name, String patronym) {
        this.surname = surname;
        this.name = name;
        this.patronym = patronym;
    }

}
