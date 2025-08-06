drop table if exists guestbooks;

create table guestbooks (
    id      integer auto_increment primary key,
    name    varchar(255),
    comment varchar(8000)
);

insert into guestbooks (name, comment) values ('John', 'Hello!');
insert into guestbooks (name, comment) values ('Jane', 'Your website looks nice.');
insert into guestbooks (name, comment) values ('Joe', 'Nice to meet you. I¡¯m from LA.');
