delete from authors;
insert into authors(id, surname, name, patronym)
values (1, 'Достоевский', 'Федор', 'Михайлович'), (2, 'Маркес', 'Габриэль Гарсия', ''), (3, 'Дюморье', 'Дафна', ''),
       (4, 'Готтлиб', 'Лори', ''), (5, 'Тартт', 'Дона', '');

delete from genres;
insert into genres(id, name)
values (1, 'роман'), (2, 'магический реализм'), (3, 'триллер'), (4, 'детектив'), (5, 'трагедия'), (6, 'психология'), (7, 'фантастика');

delete from books;
insert into books(id, name, author_id)
values (1, 'Вы хотите поговорить об этом?', 4), (2, '100 лет одиночества', 2), (3, 'Щегол', 5), (4, 'Ребекка', 3),
       (5, 'Преступление и наказание', 1);

delete from books_genres;
insert into books_genres(book_id, genre_id)
values (1, 6), (2, 1), (2, 2), (3, 7), (3, 1), (3, 3), (3, 5), (4, 1), (4, 3), (4, 4), (4, 5), (5, 1);

delete from comments;
insert into comments(book_id, text)
values (5, 'Очень интересная книга'), (5, 'Это классика');
