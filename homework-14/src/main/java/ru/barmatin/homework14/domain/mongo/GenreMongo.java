package ru.barmatin.homework14.domain.mongo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Document(collection = "genres")
public class GenreMongo {
    @Id
    private String id;
    private String name;

    public GenreMongo(String name) {
        this.name = name;
    }


}
