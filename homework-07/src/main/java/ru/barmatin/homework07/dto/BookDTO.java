package ru.barmatin.homework07.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDTO {
    private long id;
    private String name;
    private String authorName;
    private List<String> genreNameList;
    private List<String> commentTextList;
}
