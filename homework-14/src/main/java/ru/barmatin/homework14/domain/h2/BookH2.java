package ru.barmatin.homework14.domain.h2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "books")
public class BookH2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(targetEntity = AuthorH2.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private AuthorH2 authorH2;

    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany(targetEntity = GenreH2.class, fetch = FetchType.LAZY)
    @JoinTable(name = "books_genres", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<GenreH2> genreH2List;

    public BookH2(String name, AuthorH2 authorH2, List<GenreH2> genreH2List) {
        this.name = name;
        this.authorH2 = authorH2;
        this.genreH2List = genreH2List;
    }

}
