package ru.barmatin.homework06.service.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework06.domain.Author;
import ru.barmatin.homework06.service.ListConverterService;
import ru.barmatin.homework06.service.OutputService;

import java.util.List;

@Service
public class AuthorOutputServiceImpl implements AuthorOutputService {
    private final OutputService outputService;
    private final ListConverterService listConverterService;

    @Autowired
    public AuthorOutputServiceImpl(OutputService outputService, ListConverterService listConverterService) {
        this.outputService = outputService;
        this.listConverterService = listConverterService;
    }

    @Override
    public void showAuthorList(List<Author> authorList) {
        outputService.outputStringLn(listConverterService.getStringFromAuthorList(authorList));
    }
}
