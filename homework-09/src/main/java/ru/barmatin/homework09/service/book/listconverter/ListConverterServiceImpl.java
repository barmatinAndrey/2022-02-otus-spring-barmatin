package ru.barmatin.homework09.service.book.listconverter;

import org.springframework.stereotype.Service;
import ru.barmatin.homework09.domain.Author;
import ru.barmatin.homework09.domain.Genre;
import ru.barmatin.homework09.dto.BookDto;

import java.util.List;

@Service
public class ListConverterServiceImpl implements ListConverterService {

    @Override
    public String getStringFromBookDTOList(List<BookDto> bookDtoList) {
        StringBuilder outputBookListBuilder = new StringBuilder();
        for (int i = 0; i< bookDtoList.size(); i++) {
            String outputBook = (i+1) + ". " + bookDtoList.get(i).getName();
            List<String> genreNameList = bookDtoList.get(i).getGenreNameList();
            StringBuilder outputGenresBuilder = new StringBuilder();
            outputGenresBuilder.append("(");
            for (int j = 0; j<genreNameList.size(); j++) {
                outputGenresBuilder.append(genreNameList.get(j));
                outputGenresBuilder.append((j == genreNameList.size() - 1) ? "" : ", ");
            }
            outputGenresBuilder.append(") (id=");
            outputGenresBuilder.append(bookDtoList.get(i).getId());
            outputGenresBuilder.append(")");
            String outputGenres = outputGenresBuilder.toString();
            outputBookListBuilder.append(outputBook);
            outputBookListBuilder.append(" - ");
            outputBookListBuilder.append(bookDtoList.get(i).getAuthorName());
            outputBookListBuilder.append(" ");
            outputBookListBuilder.append(outputGenres);
            for (String commentText: bookDtoList.get(i).getCommentTextList()) {
                outputBookListBuilder.append("\n");
                outputBookListBuilder.append(" - ");
                outputBookListBuilder.append(commentText);
            }
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

}
