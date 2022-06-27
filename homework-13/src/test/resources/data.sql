insert into authors(surname, name, patronym)
values ('Достоевский', 'Федор', 'Михайлович'), ('Маркес', 'Габриэль Гарсия', ''), ('Дюморье', 'Дафна', ''),
       ('Готтлиб', 'Лори', ''), ('Тартт', 'Дона', '');

insert into genres(name)
values ('роман'), ('магический реализм'), ('триллер'), ('детектив'), ('трагедия'), ('психология'), ('фантастика');

insert into books(name, author_id)
values ('Вы хотите поговорить об этом?', 4), ('100 лет одиночества', 2), ('Щегол', 5), ('Ребекка', 3),
       ('Преступление и наказание', 1);

insert into books_genres(book_id, genre_id)
values (1, 6), (2, 1), (2, 2), (3, 7), (3, 1), (3, 3), (3, 5), (4, 1), (4, 3), (4, 4), (4, 5), (5, 1);

insert into comments(book_id, text)
values (5, 'Очень интересная книга'), (5, 'Это классика');

insert into users(username, password, role)
values ('Ivanov', '$2a$10$m1eWIiEvfd2K8YFhXupoM.cKNHLm67ILiu3BcoFnVvdjJjOFUUvGS', 'USER'),
('Petrov', '$2a$10$rXFAmbbs1ohzts41xXmnrevIX3foNbvnF7.v/SPslDAiN0ONKNzbe', 'USER'),
('Sidorov', '$2a$10$X3IJNLZlu0plVUJ3TTu0EeEfEwx5QtSwov2oM0aaS9uKLD3mstqau', 'USER');