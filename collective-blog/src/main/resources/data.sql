insert into blog_users(username, password, role, surname, name, email)
values ('barmatin', '$2a$10$m1eWIiEvfd2K8YFhXupoM.cKNHLm67ILiu3BcoFnVvdjJjOFUUvGS', 'ADMIN', 'Барматин', 'Андрей', 'barmatin.andrey@mail.ru');

insert into post_categories(name)
values ('Политика'), ('Экономика'), ('Общество'), ('Культура'), ('Происшествия'), ('Интересное');

insert into posts(blog_user_id, post_category_id, title, content, post_date, is_visible)
values (1, 5, 'Аксенов сообщил о двух пострадавших в результате ЧП на севере Крыма', '"Нахожусь в селе Азовском Джанкойского района, где сегодня утром, по данным министерства обороны, произошло возгорание на территории площадки временного хранения боеприпасов одной из воинских частей. На данный момент продолжается детонация", - написал Аксенов.', '2022-08-16 15:39:59', true),
       (1, 2, 'В МИД России заявили о колоссальных темпах роста товарооборота с Китаем', 'Товарооборот России и КНР растет колоссальными темпами, заявил директор департамента экономического сотрудничества МИД РФ Дмитрий Биричевский эфире телеканала «Россия 24».', '2022-08-17 22:06:59', true);

insert into post_comments(post_id, blog_user_id, post_comment_date, content)
values (1, 1, '2022-08-17 22:06:59', 'ТЕСТОВЫЙ КОММЕНТАРИЙ');

insert into tags(name)
values ('Крым'), ('Россия'), ('Новости'), ('Тест');

insert into posts_tags(post_id, tag_id)
values (2, 1), (2, 2), (2, 3), (1,4);