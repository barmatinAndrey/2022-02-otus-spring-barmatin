package ru.barmatin.homework17.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDto {
    private long id;
    private String name;
    private String authorName;
    private List<String> genreNameList;
    private List<String> commentTextList;
}
