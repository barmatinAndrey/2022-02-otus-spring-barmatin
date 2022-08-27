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