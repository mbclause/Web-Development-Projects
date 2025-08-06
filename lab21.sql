drop table if exists faculty;
drop table if exists departments;

create table faculty (
    id             integer auto_increment primary key,
	name           varchar(255),
    department_id  integer references departments(id),
    is_chair       integer
);


create table departments (
    id    integer auto_increment primary key,
	name  varchar(255)
);

insert into departments values (1, "Computer Science");

insert into departments values (2, "Electrical and Computer Engineering");
