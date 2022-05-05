package ru.barmatin.homework08.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookInputDTO {
    private String id;
    private String name;
    private String authorId;
    private List<String> genreIdList;
}
