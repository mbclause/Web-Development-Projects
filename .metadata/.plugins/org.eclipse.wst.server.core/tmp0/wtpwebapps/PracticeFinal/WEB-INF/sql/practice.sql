drop table if exists quarter_courses;

drop table if exists semester_courses;

drop table if exists course_mappings;


create table quarter_courses (
	id   int primary key auto_increment,
    
    name   varchar(100),
    
    is_mapped  int
);


create table semester_courses (

	id  int primary key auto_increment,
    
    name   varchar(100),
    
	is_mapped  int
);


create table course_mappings (

	id  int primary key auto_increment,
    
    quarter_course_id  int references quarter_courses(id),
    
    semester_course_id  int references semester_courses(id)
    
   );
    
insert into semester_courses values (1, CS2011, 1);
insert into semester_courses values (2, CS2012, 1);
insert into semester_courses values (3, CS2013, 0);

insert into quarter_courses values (1, CS122, 0);
insert into quarter_courses values (2, CS201, 1);
insert into quarter_courses values (3, CS202, 1);
insert into quarter_courses values (4, CS203, 0);

insert into course_mappings values (1, 2, 1);
insert into course_mappings values (2, 3, 2);