-- it only use to save the structure of sql, it require to paste it on mysql to create table

CREATE SCHEMA `mylib_db` ;

use mylib_db;

create table book(
	book_id int not null auto_increment,
    book_name varchar(70),
    book_discr varchar(200),
    public_date date,
    primary key(book_id)
);
-- link

create table author(
	author_id int not null auto_increment,
    author_name varchar(50),
	primary key(author_id)
);

create table book_info(
	id int not null auto_increment,
    book_id int,
    author_id int,
    primary key(id),
    foreign key(book_id) references book(book_id),
    foreign key(author_id) references author(author_id)
);

insert into book(book_name,book_discr,public_date) values('name1','this should be the info about book','2000-10-10');
insert into book(book_name,book_discr,public_date) values('name2','this should be the info about book','2000-11-10'),
('name3','this should be the info about book','2000-12-10'),('name4','this should be the info about book','2000-11-11'),
('name5','this should be the info about book','2001-11-10');

insert into author(author_name) values('author A');
insert into author(author_name) values('author B'),('author C'),('author D');

insert into book_info(book_id,author_id) values(1,1);

insert into book_info(book_id,author_id) values(1,2);
insert into book_info(book_id,author_id) values(2,1);
insert into book_info(book_id,author_id) values(1,3);
insert into book_info(book_id,author_id) values(1,4);
insert into book_info(book_id,author_id) values(4,3);


Select *from book;
select * from book_info;

use bookstore_db;
select * from authors;
select * from books;
