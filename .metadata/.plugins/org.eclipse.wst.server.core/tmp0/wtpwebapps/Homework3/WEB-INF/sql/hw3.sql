drop table if exists forums;
drop table if exists topics;
drop table if exists posts;



create table forums (
	id    integer primary key auto_increment,
    
    name  varchar(100),
    
    num_topics    integer
);



create table topics(

	id   integer primary key auto_increment,
    
    name   varchar(100),
    
    author  varchar(100),
    
    num_replies  integer,
    
    time_stamp  varchar(100),
    
    forum_id   integer references forums(id)
);



create table posts(
	id      integer primary key auto_increment,

	author  varchar(100),
    
    content  varchar(8000),
    
    time_stamp  varchar(100),
    
    topic_id   integer references topics(id)
);

insert into forums values(1, 'General Discussion', 0);

insert into forums values(2, 'CS3220 Web Programming', 0);
    
    