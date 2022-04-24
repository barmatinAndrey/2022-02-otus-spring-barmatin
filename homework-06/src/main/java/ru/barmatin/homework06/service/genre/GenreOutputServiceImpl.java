package ru.barmatin.homework06.service.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework06.domain.Genre;
import ru.barmatin.homework06.service.ListConverterService;
import ru.barmatin.homework06.service.OutputService;

import java.util.List;

@Service
public class GenreOutputServiceImpl implements GenreOutputService {
    private final OutputService outputService;
    private final ListConverterService listConverterService;

    @Autowired
    public GenreOutputServiceImpl(OutputService outputService, ListConverterService listConverterService) {
        this.outputService = outputService;
        this.listConverterService = listConverterService;
    }

    @Override
    public void showGenreList(List<Genre> genreList) {
        outputService.outputStringLn(listConverterService.getStringFromGenreList(genreList));
    }
}
