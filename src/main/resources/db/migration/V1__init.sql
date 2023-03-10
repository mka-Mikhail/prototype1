create table tasks
(
    id          bigserial,
    title       varchar(100),
    description varchar(255)
);

create table users
(
    id         bigserial,
    email      varchar(100) not null,
    password   varchar(100) not null,
    first_name varchar(100) not null,
    last_name  varchar(100) not null,
    role       varchar(100) not null,
    status     varchar(100) not null
);

insert into tasks (title, description)
values ('ПРОТОТИП', 'Авторизация, Регистрация, БД');

insert into users (email, password, first_name, last_name, role, status)
values ('admin@mail.com', 'pass', 'Mka', 'Rozh', 'ADMIN', 'ACTIVE');
