-- List the names of the users. The names should be in the form of "first_name last_name".

select concat(first_name, ' ', last_name) as 'Name' from users;

-- List the names of the forums. The results should be ordered by forum id in ascending order.

select name from forums
group by name
order by id asc;

/* List the topics in the forum with forum id=2. For each topic, the results should include the subject, 
 the author's first name, the number of replies, and the timestamp of the last post in the topic.*/
 
 select t.subject, u.first_name, t.num_of_replies, t.last_post_time
 from topics t inner join users u on t.author_id = u.id
 where t.forum_id = 2;

/* List the posts in the topic with the subject "Eclipse problem". The results should be ordered by timestamp in ascending order, 
 and for each post, it should include the author's first name, the content, and the timestamp.*/
 
 select u.first_name, p.content, p.timestamp
 from posts p inner join topics t on p.topic_id = t.id
 inner join users u on p.author_id = u.id
 where t.subject = 'Eclipse problem'
 order by p.timestamp asc;

-- List the names of the forums, and for each forum, the number of topics in the forum (or 0 for forums that do not have any topic).

select f.name, count(t.id) 
from forums f left join topics t on f.id = t.forum_id
group by f.name;

-- List the subjects of the topics created by John Doe.

select t.subject
from topics t inner join users u on t.author_id = u.id
where u.first_name = 'John' and u.last_name = 'Doe'
group by t.subject;