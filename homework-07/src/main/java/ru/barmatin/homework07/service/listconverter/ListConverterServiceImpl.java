package ru.barmatin.homework07.service.listconverter;

import org.springframework.stereotype.Service;
import ru.barmatin.homework07.domain.Author;
import ru.barmatin.homework07.domain.Book;
import ru.barmatin.homework07.domain.Comment;
import ru.barmatin.homework07.domain.Genre;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListConverterServiceImpl implements ListConverterService {

    @Override
    public String getStringFromBookList(List<Book> bookList) {
        StringBuilder outputBookListBuilder = new StringBuilder();
        for (int i=0; i<bookList.size(); i++) {
            String outputBook = (i+1) + ". " + bookList.get(i).getName();
            String outputAuthor = bookList.get(i).getAuthor().getSurname() + " " + bookList.get(i).getAuthor().getName() +
                    (bookList.get(i).getAuthor().getPatronym().isEmpty() ? "" : " "+bookList.get(i).getAuthor().getPatronym());
            List<Genre> genreList = bookList.get(i).getGenreList();
            StringBuilder outputGenresBuilder = new StringBuilder();
            outputGenresBuilder.append("(");
            for (int j = 0; j<genreList.size(); j++) {
                outputGenresBuilder.append(genreList.get(j).getName());
                outputGenresBuilder.append((j == genreList.size() - 1) ? "" : ", ");
            }
            outputGenresBuilder.append(") (id=");
            outputGenresBuilder.append(bookList.get(i).getId());
            outputGenresBuilder.append(")");
            String outputGenres = outputGenresBuilder.toString();
            outputBookListBuilder.append(outputBook);
            outputBookListBuilder.append(" - ");
            outputBookListBuilder.append(outputAuthor);
            outputBookListBuilder.append(" ");
            outputBookListBuilder.append(outputGenres);
            outputBookListBuilder.append("\n");
        }
        return outputBookListBuilder.toString();
    }

    @Override
    public String getStringFromGenreList(List<Genre> genreList) {
        StringBuilder outputGenreListBuilder = new StringBuilder();
        for (int i=0; i<genreList.size(); i++) {
            outputGenreListBuilder.append((i+1));
            outputGenreListBuilder.append(". ");
            outputGenreListBuilder.append(genreList.get(i).getName());
            outputGenreListBuilder.append("\n");
        }
        return outputGenreListBuilder.toString();
    }

    @Override
    public String getStringFromAuthorList(List<Author> authorList) {
        StringBuilder outputAuthorListBuilder = new StringBuilder();
        for (int i=0; i<authorList.size(); i++) {
            outputAuthorListBuilder.append((i+1));
            outputAuthorListBuilder.append(". ");
            outputAuthorListBuilder.append(authorList.get(i).getSurname());
            outputAuthorListBuilder.append(" ");
            outputAuthorListBuilder.append(authorList.get(i).getName());
            if (!authorList.get(i).getPatronym().isEmpty()) {
                outputAuthorListBuilder.append(" ");
            }
            outputAuthorListBuilder.append(authorList.get(i).getPatronym());
            outputAuthorListBuilder.append("\n");
        }
        return outputAuthorListBuilder.toString();
    }

    @Override
    public String getStringFromCommentList(List<Comment> commentList) {
        StringBuilder outputCommentListBuilder = new StringBuilder();
        if (!commentList.isEmpty()) {
            Book book = commentList.get(0).getBook();
            List<Book> bookList = new ArrayList<>();
            bookList.add(book);
            outputCommentListBuilder.append(getStringFromBookList(bookList));
            for (Comment comment : commentList) {
                outputCommentListBuilder.append("- ");
                outputCommentListBuilder.append(comment.getText());
                outputCommentListBuilder.append("\n");
            }
        }
        return outputCommentListBuilder.toString();
    }
}
