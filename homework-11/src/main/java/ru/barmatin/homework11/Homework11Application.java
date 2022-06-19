package ru.barmatin.homework11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Flux;
import ru.barmatin.homework11.domain.Author;
import ru.barmatin.homework11.domain.Book;
import ru.barmatin.homework11.domain.Genre;
import ru.barmatin.homework11.repository.AuthorRepository;
import ru.barmatin.homework11.repository.BookRepository;
import ru.barmatin.homework11.repository.GenreRepository;

import java.util.*;

@EnableReactiveMongoRepositories
@SpringBootApplication
public class Homework11Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Homework11Application.class);

		AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
		GenreRepository genreRepository = context.getBean(GenreRepository.class);
		BookRepository bookRepository = context.getBean(BookRepository.class);

		Flux<Author> authorFlux = authorRepository.saveAll(Arrays.asList(
				new Author("Достоевский", "Федор", "Михайлович"),
				new Author("Маркес", "Габриэль Гарсия", ""),
				new Author("Дюморье", "Дафна", ""),
				new Author("Готтлиб", "Лори", ""),
				new Author("Тартт", "Дона", "")
		));

		Flux<Genre> genreFlux = genreRepository.saveAll(Arrays.asList(
				new Genre("роман"),
				new Genre("магический реализм"),
				new Genre("триллер"),
				new Genre("детектив"),
				new Genre("трагедия"),
				new Genre("психология"),
				new Genre("фантастика")
		));

		Map<String, Author> authorMap = new HashMap<>();
		Map<String, Genre> genreMap = new HashMap<>();

		Flux.merge(authorFlux, genreFlux)
				.doOnComplete(() -> bookRepository.saveAll(Arrays.asList(
						new Book("Вы хотите поговорить об этом?", authorMap.get("Готтлиб"), List.of(genreMap.get("психология"))),
						new Book("100 лет одиночества", authorMap.get("Маркес"), List.of(genreMap.get("роман"), genreMap.get("магический реализм"))),
						new Book("Щегол", authorMap.get("Тартт"), List.of(genreMap.get("роман"), genreMap.get("триллер"), genreMap.get("трагедия"), genreMap.get("фантастика"))),
						new Book("Ребекка", authorMap.get("Дюморье"), List.of(genreMap.get("роман"), genreMap.get("триллер"), genreMap.get("детектив"), genreMap.get("трагедия"))),
						new Book("Преступление и наказание", authorMap.get("Достоевский"), List.of(genreMap.get("роман"))))
				).subscribe())
				.subscribe(object -> {
					if (object.getClass() == Author.class) {
						authorMap.put(((Author) object).getSurname(), (Author)object);
					}
					else if (object.getClass() == Genre.class) {
						genreMap.put(((Genre) object).getName(), (Genre)object);
					}
		});

	}

}
