insert into authors (id, surname, name, patronym) values (1, 'Достоевский', 'Федор', 'Михайлович');
insert into authors (id, surname, name, patronym) values (2, 'Маркес', 'Габриэль Гарсия', '');
insert into authors (id, surname, name, patronym) values (3, 'Дюморье', 'Дафна', '');
insert into authors (id, surname, name, patronym) values (4, 'Готтлиб', 'Лори', '');
insert into authors (id, surname, name, patronym) values (5, 'Тартт', 'Дона', '');

insert into genres (id, name) values (1, 'роман');
insert into genres (id, name) values (2, 'магический реализм');
insert into genres (id, name) values (3, 'триллер');
insert into genres (id, name) values (4, 'детектив');
insert into genres (id, name) values (5, 'трагедия');
insert into genres (id, name) values (6, 'психология');
insert into genres (id, name) values (7, 'фантастика');

insert into books (id, name, author_id) values (1, 'Вы хотите поговорить об этом?', 4);
insert into books (id, name, author_id) values (2, '100 лет одиночества', 2);
insert into books (id, name, author_id) values (3, 'Щегол', 5);
insert into books (id, name, author_id) values (4, 'Ребекка', 3);
insert into books (id, name, author_id) values (5, 'Преступление и наказание', 1);

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
