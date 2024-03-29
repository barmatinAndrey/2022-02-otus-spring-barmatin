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
values ('Политика'), ('Экономика'), ('Общество'), ('Культура'), ('Происшествия'), ('История'), ('Новости');

insert into posts(blog_user_id, post_category_id, title, content, post_date, is_visible)
values (1, 6, 'Как бельгийский король Леопольд II уничтожил 10 миллионов африканцев', 'О том, как король самой прогрессивной страны превратил 20 миллионов африканцев в своих рабов и как общественные организации боролись с их порабощением, став прообразом правозащитных движений будущего Все началось с проведения в 1876 году в Брюсселе географической конференции, на которой были озвучены предложения короля Бельгии Леопольда II о приобщении жителей Центральной Африки к цивилизации и западным ценностям. На собрание съехались именитые гости из разных стран. В основном это были ученые и путешественники. Среди них легендарный Герхард Рольфс, сумевший под видом мусульманина пробраться в самые закрытые районы Марокко, и барон фон Рихтгофен — президент Берлинского географического общества и основоположник геоморфологии. Барон фон Рихтгофен был дядей легендарного «красного барона» Манфреда фон Рихтгофена, лучшего пилота Первой мировой войны. От России прибыл известный географ и путешественник Петр Семенов-Тян-Шанский, который председательствовал на конференции. По итогам собрания учреждается Международная Африканская ассоциация под руководством Леопольда II. Кроме того, король учреждает еще две организации: Комитет для изучения Верхнего Конго и Международное общество Конго. Эти организации использовались им для утверждения своего влияния в бассейне реки Конго. Эмиссары короля подписали сотни договоров с вождями местных племен, согласно которым права на землю передавались Ассоциации. Договоры заключались на английском или французском языках, поэтому вожди племен понятия не имели, какие права и в каком объеме они передавали. Впрочем, колониальные империи и строились посредством такого рода договоров, так что Леопольд II не отличался особой находчивостью. ', '2022-08-16 15:39:59', true),
       (1, 7, 'Приостановившие деятельность автоконцерны определились по поводу работы в России', 'Заявившие о приостановлении своей деятельности на территории России автомобильные концерны определились по поводу дальнейшей работы в стране. Какие именно предприятия покинут рынок окончательно, сообщили «Известия». По данным издания, компании Nokian и Mercedes-Benz в настоящее время ведут переговоры о продаже предприятий на территории РФ. Потенциальным покупателем немецкого завода в Солнечногорске может стать российская компания «Автодом». В свою очередь финский производитель сообщил, что совет директоров компании принял решение о «контролируемом уходе» из страны. В настоящее время рассматриваются разные сценарии реализации этого плана, в том числе идут переговоры с возможными инвесторами, а также о блокировке всех процессов и систем, которые обеспечивают работу. Не исключены простои завода по причине нехватки сырья. При этом губернатор Ленобласти Дрозденко сообщил, что после ухода Nokian предприятие сменит название и начнет искать новые рынки сбыта. Интерес к этому заводу уже проявили компания «Татнефть» и концерн AEON. При этом эксперты не исключают, что в договоре о продаже Mercedes-Benz может быть прописана возможность со временем выкупить предприятие, как было сделано с Renault. В случае, если геополитическая обстановка изменится, производитель сможет вернуться на рынок России. Операции по продаже также могут изучать Ford, Volkswagen, BMW. Профильные специалисты уверены, что эти компании в настоящее время занимаются поиском возможностей по реализации своих площадок в России. В свою очередь корейские и японские компании меньше задумываются о продаже российских активов.', '2022-08-17 22:06:59', false);

insert into post_comments(post_id, blog_user_id, post_comment_date, content)
values (1, 1, '2022-08-17 22:06:59', 'ТЕСТОВЫЙ КОММЕНТАРИЙ');

insert into tags(name)
values ('Конго'), ('Африка'), ('Леопольд 2'), ('Рабство'), ('Текст'), ('Длиннопост'), ('Авто');

insert into posts_tags(post_id, tag_id)
values (1, 1), (1, 2), (1, 3), (1,4), (1,5), (1,6), (2,7);