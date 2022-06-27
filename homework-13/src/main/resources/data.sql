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
values ('Ivanov', '$2a$10$m1eWIiEvfd2K8YFhXupoM.cKNHLm67ILiu3BcoFnVvdjJjOFUUvGS', 'ADMIN'),
('Petrov', '$2a$10$rXFAmbbs1ohzts41xXmnrevIX3foNbvnF7.v/SPslDAiN0ONKNzbe', 'ADMIN'),
('Sidorov', '$2a$10$X3IJNLZlu0plVUJ3TTu0EeEfEwx5QtSwov2oM0aaS9uKLD3mstqau', 'USER');

INSERT INTO acl_sid (id, principal, sid) VALUES
(1, 1, 'Ivanov'),
(2, 1, 'Petrov'),
(3, 0, 'Sidorov');

INSERT INTO acl_class (id, class) VALUES
(1, 'ru.barmatin.homework13.domain.Book');

INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) VALUES
(1, 1, 1, NULL, 3, 0),
(2, 1, 2, NULL, 3, 0),
(3, 1, 3, NULL, 3, 0),
(4, 1, 4, NULL, 3, 0),
(5, 1, 5, NULL, 3, 0);

INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask,
                       granting, audit_success, audit_failure) VALUES
(1, 1, 1, 1, 1, 1, 1, 1),
(2, 2, 1, 1, 1, 1, 1, 1),
(3, 3, 1, 1, 1, 1, 1, 1),
(4, 4, 1, 1, 1, 1, 1, 1),
(5, 5, 1, 1, 1, 1, 1, 1),

(6, 1, 2, 2, 1, 1, 1, 1),
(7, 2, 2, 2, 1, 1, 1, 1),
(8, 3, 2, 2, 1, 1, 1, 1),
(9, 4, 2, 2, 1, 1, 1, 1),
(10, 5, 2, 2, 1, 1, 1, 1),

(11, 1, 3, 3, 1, 1, 1, 1),
(12, 2, 3, 3, 1, 1, 1, 1),
(13, 3, 3, 3, 1, 1, 1, 1),
(14, 4, 3, 3, 1, 1, 1, 1),
(15, 5, 3, 3, 1, 1, 1, 1);

