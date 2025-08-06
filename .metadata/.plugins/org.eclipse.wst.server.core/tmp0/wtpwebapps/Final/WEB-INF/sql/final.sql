


create table books (
	id   int primary key auto_increment,
    
    name   varchar(100),
    
    genre_id    int references genres(id),
    
    num_votes  int
);

create table genres (
	id   int primary key auto_increment,
    
    name   varchar(100)
);

insert into genres values (1, 'Fantasy');
insert into genres values (2, 'Nonfiction');

insert into books values (1, 'A Game of Thrones', 1, 10);
insert into books values (2, 'Flash Boys', 2, 8);
insert into books values (3, 'Mistborn: The Final Empire', 1, 5);

