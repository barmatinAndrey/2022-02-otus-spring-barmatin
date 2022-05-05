package ru.barmatin.homework08.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework08.dto.BookDTO;
import ru.barmatin.homework08.service.book.listconverter.ListConverterService;
import ru.barmatin.homework08.service.io.OutputService;
import ru.barmatin.homework08.service.message.MessageService;

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
    public void showBookList(List<BookDTO> bookDTOList) {
        outputService.outputStringLn(listConverterService.getStringFromBookDTOList(bookDTOList));
    }

    @Override
    public void showBook(BookDTO bookDTO) {
        if (bookDTO != null) {
            List<BookDTO> bookDTOList = new ArrayList<>();
            bookDTOList.add(bookDTO);
            outputService.outputStringLn(listConverterService.getStringFromBookDTOList(bookDTOList));
        }
        else {
            outputService.outputStringLn(messageService.getMessage("strings.book.is.absent"));
        }
    }

}
