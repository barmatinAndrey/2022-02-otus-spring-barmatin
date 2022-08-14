drop table if exists blog_users;
create table blog_users(
    id int auto_increment,
    username varchar(255),
    password varchar(255),
    role varchar(255),
    surname varchar(255),
    name varchar(255),
    email varchar(255),
    primary key(id)
);