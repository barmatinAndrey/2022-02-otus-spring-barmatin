insert into authors (id, surname, name, patronym) values ((values next value for authors_sequence), 'Достоевский', 'Федор', 'Михайлович');
insert into authors (id, surname, name, patronym) values ((values next value for authors_sequence), 'Маркес', 'Габриэль Гарсия', '');
insert into authors (id, surname, name, patronym) values ((values next value for authors_sequence), 'Дюморье', 'Дафна', '');
insert into authors (id, surname, name, patronym) values ((values next value for authors_sequence), 'Готтлиб', 'Лори', '');
insert into authors (id, surname, name, patronym) values ((values next value for authors_sequence), 'Тартт', 'Дона', '');

insert into genres (id, name) values ((values next value for genres_sequence), 'роман');
insert into genres (id, name) values ((values next value for genres_sequence), 'магический реализм');
insert into genres (id, name) values ((values next value for genres_sequence), 'триллер');
insert into genres (id, name) values ((values next value for genres_sequence), 'детектив');
insert into genres (id, name) values ((values next value for genres_sequence), 'трагедия');
insert into genres (id, name) values ((values next value for genres_sequence), 'психология');
insert into genres (id, name) values ((values next value for genres_sequence), 'фантастика');

insert into books (id, name, author_id) values ((values next value for books_sequence), 'Вы хотите поговорить об этом?', 4);
insert into books (id, name, author_id) values ((values next value for books_sequence), '100 лет одиночества', 2);
insert into books (id, name, author_id) values ((values next value for books_sequence), 'Щегол', 5);
insert into books (id, name, author_id) values ((values next value for books_sequence), 'Ребекка', 3);
insert into books (id, name, author_id) values ((values next value for books_sequence), 'Преступление и наказание', 1);

insert into books_genres (book_id, genre_id) values (1, 6);
insert into books_genres (book_id, genre_id) values (2, 1);
insert into books_genres (book_id, genre_id) values (2, 2);
insert into books_genres (book_id, genre_id) values (3, 7);
insert into books_genres (book_id, genre_id) values (3, 1);
insert into books_genres (book_id, genre_id) values (3, 3);
insert into books_genres (book_id, genre_id) values (3, 5);
insert into books_genres (book_id, genre_id) values (4, 1);
insert into books_genres (book_id, genre_id) values (4, 3);
insert into books_genres (book_id, genre_id) values (4, 4);
insert into books_genres (book_id, genre_id) values (4, 5);
insert into books_genres (book_id, genre_id) values (5, 1);
