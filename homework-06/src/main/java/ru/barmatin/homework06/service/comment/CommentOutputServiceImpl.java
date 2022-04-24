package ru.barmatin.homework06.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework06.domain.Comment;
import ru.barmatin.homework06.service.ListConverterService;
import ru.barmatin.homework06.service.OutputService;

import java.util.List;

@Service
public class CommentOutputServiceImpl implements CommentOutputService {
    private final OutputService outputService;
    private final ListConverterService listConverterService;


    @Autowired
    public CommentOutputServiceImpl(OutputService outputService, ListConverterService listConverterService) {
        this.outputService = outputService;
        this.listConverterService = listConverterService;
    }

    @Override
    public void showCommentList(List<Comment> commentList) {
        outputService.outputStringLn(listConverterService.getStringFromCommentList(commentList));
    }

}
