drop table if exists authors;
create table authors(
    id bigserial,
    surname varchar(255),
    name varchar(255),
    patronym varchar(255),
    primary key(id)
);

drop table if exists genres;
create table genres(
    id bigserial,
    name varchar(255),
    primary key(id)
);

drop table if exists books;
create table books(
    id bigserial,
    name varchar(255),
    author_id bigint references authors(id),
    primary key(id)
);

drop table if exists books_genres;
create table books_genres(
    book_id bigint references books(id) on delete cascade,
    genre_id bigint references genres(id),
    primary key(book_id, genre_id)
);

drop table if exists comments;
create table comments(
    id bigserial,
    book_id bigint references books(id) on delete cascade,
    text varchar(1000),
    primary key(id)
);

drop table if exists users;
create table users(
    id bigserial,
    username varchar(255),
    password varchar(255),
    role varchar(255),
    primary key(id)
);