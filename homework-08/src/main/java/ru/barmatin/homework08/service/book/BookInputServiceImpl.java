package ru.barmatin.homework08.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework08.domain.Author;
import ru.barmatin.homework08.domain.Book;
import ru.barmatin.homework08.domain.Genre;
import ru.barmatin.homework08.dto.BookInputDTO;
import ru.barmatin.homework08.service.io.IOService;
import ru.barmatin.homework08.service.message.MessageService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookInputServiceImpl implements BookInputService {
    private final MessageService messageService;
    private final IOService ioService;

    @Autowired
    public BookInputServiceImpl(IOService ioService, MessageService messageService) {
        this.messageService = messageService;
        this.ioService = ioService;
    }

    @Override
    public BookInputDTO getBookInputDTO(boolean isNewBook) {
        String bookId = null;
        if (!isNewBook) {
            ioService.outputString(messageService.getMessage("strings.enter.book.id.to.edit")+" ");
            bookId = ioService.readString();
        }
        ioService.outputString(messageService.getMessage("strings.enter.book.name")+" ");
        String bookName = ioService.readString();
        ioService.outputString(messageService.getMessage("strings.enter.author.id")+" ");
        String authorId = ioService.readString();
        List<String> genreIdList = new ArrayList<>();
        ioService.outputString(messageService.getMessage("strings.enter.genre.id")+" ");
        genreIdList.add(ioService.readString());
        while(true) {
            ioService.outputString(messageService.getMessage("strings.enter.genre.id.or.null")+" ");
            String genreId = ioService.readString();
            if (genreId.equals("0")) {
                break;
            }
            else {
                genreIdList.add(genreId);
            }
        }
        return new BookInputDTO(bookId, bookName,authorId, genreIdList);
    }

}
