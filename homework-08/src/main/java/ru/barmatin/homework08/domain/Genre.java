package ru.barmatin.homework08.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Document(collection = "genres")
public class Genre {
    @Id
    private String id;
    private String name;

    public Genre(String name) {
        this.name = name;
    }


}