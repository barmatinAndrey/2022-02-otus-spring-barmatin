insert into blog_users(username, password, role, surname, name, email)
values ('barmatin', '$2a$10$m1eWIiEvfd2K8YFhXupoM.cKNHLm67ILiu3BcoFnVvdjJjOFUUvGS', 'ADMIN', 'Барматин', 'Андрей', 'barmatin.andrey@mail.ru');

insert into post_categories(name)
values ('Политика'), ('Экономика'), ('Общество'), ('Культура'), ('Происшествия'), ('Интересное');

insert into posts(blog_user_id, post_category_id, name, content, post_date, is_visible)
values (1, 2, 'Аксенов сообщил о двух пострадавших в результате ЧП на севере Крыма', '"Нахожусь в селе Азовском Джанкойского района, где сегодня утром, по данным министерства обороны, произошло возгорание на территории площадки временного хранения боеприпасов одной из воинских частей. На данный момент продолжается детонация", - написал Аксенов.', '2022-08-16 15:39:59', true)