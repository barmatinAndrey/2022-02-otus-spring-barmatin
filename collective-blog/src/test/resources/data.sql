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

drop table if exists post_categories;
create table post_categories(
    id int auto_increment,
    name varchar(255),
    primary key(id)
);

drop table if exists posts;
create table posts(
    id int auto_increment,
    blog_user_id int references blog_users(id),
    post_category_id int references post_categories(id),
    title varchar(255),
    content text,
    post_date datetime,
    is_visible bool,
    primary key(id)
);

drop table if exists post_comments;
create table post_comments(
    id int auto_increment,
    post_id int references posts(id) on delete cascade,
    blog_user_id int references blog_users(id) on delete cascade,
    post_comment_date datetime,
    content text,
    primary key (id)
);

drop table if exists tags;
create table tags(
    id int auto_increment,
    name varchar(255),
    primary key(id)
);

drop table if exists posts_tags;
create table posts_tags(
    post_id int references posts(id) on delete cascade,
    tag_id int references tags(id),
    primary key (post_id, tag_id)
);



insert into blog_users(username, password, role, surname, name, email)
values ('barmatin', '$2a$10$m1eWIiEvfd2K8YFhXupoM.cKNHLm67ILiu3BcoFnVvdjJjOFUUvGS', 'ADMIN', 'Барматин', 'Андрей', 'barmatin.andrey@mail.ru');

insert into post_categories(name)
values ('Политика'), ('Экономика'), ('Общество'), ('Культура'), ('Происшествия'), ('Интересное');

insert into posts(blog_user_id, post_category_id, title, content, post_date, is_visible)
values (1, 5, 'Аксенов сообщил о двух пострадавших в результате ЧП на севере Крыма', '"Нахожусь в селе Азовском Джанкойского района, где сегодня утром, по данным министерства обороны, произошло возгорание на территории площадки временного хранения боеприпасов одной из воинских частей. На данный момент продолжается детонация", - написал Аксенов.', '2022-08-16 15:39:59', true),
       (1, 2, 'В МИД России заявили о колоссальных темпах роста товарооборота с Китаем', 'Товарооборот России и КНР растет колоссальными темпами, заявил директор департамента экономического сотрудничества МИД РФ Дмитрий Биричевский эфире телеканала «Россия 24».', '2022-08-17 22:06:59', false);

insert into post_comments(post_id, blog_user_id, post_comment_date, content)
values (1, 1, '2022-08-17 22:06:59', 'ТЕСТОВЫЙ КОММЕНТАРИЙ');

insert into tags(name)
values ('Крым'), ('Россия'), ('Новости'), ('Тест');

insert into posts_tags(post_id, tag_id)
values (2, 1), (2, 2), (2, 3), (1,4);