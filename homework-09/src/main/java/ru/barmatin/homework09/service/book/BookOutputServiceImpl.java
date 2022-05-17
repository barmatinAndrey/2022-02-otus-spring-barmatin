package ru.barmatin.homework09.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework09.dto.BookDto;
import ru.barmatin.homework09.service.book.listconverter.ListConverterService;
import ru.barmatin.homework09.service.io.OutputService;
import ru.barmatin.homework09.service.message.MessageService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookOutputServiceImpl implements BookOutputService {
    private final OutputService outputService;
    private final ListConverterService listConverterService;
    private final MessageService messageService;

    @Autowired
    public BookOutputServiceImpl(OutputService outputService, ListConverterService listConverterService, MessageService messageService) {
        this.outputService = outputService;
        this.listConverterService = listConverterService;
        this.messageService = messageService;
    }

    @Override
    public void showBookList(List<BookDto> bookDtoList) {
        outputService.outputStringLn(listConverterService.getStringFromBookDTOList(bookDtoList));
    }

    @Override
    public void showBook(BookDto bookDTO) {
        if (bookDTO != null) {
            List<BookDto> bookDtoList = new ArrayList<>();
            bookDtoList.add(bookDTO);
            outputService.outputStringLn(listConverterService.getStringFromBookDTOList(bookDtoList));
        }
        else {
            outputService.outputStringLn(messageService.getMessage("strings.book.is.absent"));
        }
    }

}
