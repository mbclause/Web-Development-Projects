drop table if exists posts;
drop table if exists topics;
drop table if exists forums;
drop table if exists users;

create table users (
    id          integer auto_increment primary key,
    username    varchar(255) unique not null,
    password    varchar(255),
    first_name  varchar(255),
    last_name   varchar(255)
);

insert into users values (1, 'jdoe1', 'abcd', 'John', 'Doe');
insert into users values (2, 'jdoe2', 'abcd', 'Jane', 'Doe');

create table forums (
    id          integer auto_increment primary key,
    name        varchar(255) unique not null
);

insert into forums values (1, 'General Discussion');
insert into forums values (2, 'CS3220 Web Programming');

create table topics (
    id              integer auto_increment primary key,
    forum_id        integer references forums(id),
    subject         varchar(255),
    author_id       integer references users(id),
    num_of_replies  integer default 0,
    last_post_time  timestamp default now()
);

insert into topics values (1, 2, 'Eclipse problem', 1, 1, '2020-02-20 14:17:12');
insert into topics values (2, 2, 'HW1 HELP!', 2, 0, '2020-02-25 09:01:02');

create table posts (
    id          integer auto_increment primary key,
    topic_id    integer references topics(id),
    author_id   integer references users(id),
    content     varchar(8000),
    timestamp   timestamp
);

insert into posts values (1, 1, 1, 'I couldn''t find Dynamic Web Project.', '2020-02-19 20:34:27');
insert into posts values (2, 1, 2, 'You probably got the wrong Eclipse package.', '2020-02-20 14:17:12');
insert into posts values (3, 2, 2, 'I need help for HW1.', '2020-02-25 09:01:02');
