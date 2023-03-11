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
    role       varchar(100) not null default 'ADMIN',
    status     varchar(100) not null default 'ACTIVE'
);

insert into tasks (title, description)
values ('ПРОТОТИП', 'Авторизация, Регистрация, БД');

--password - pass
insert into users (email, password, first_name, last_name, role, status)
values ('admin@mail.com', '$2a$12$vnc/mhHJcVLyToVxJXHUp.9hgM3c3ryNGVDPsUtr/mARLpXrtkQ02', 'Mka', 'Rozh', 'ADMIN', 'ACTIVE');
