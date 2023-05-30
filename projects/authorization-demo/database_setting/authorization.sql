create schema authorization_db;
use authorization_db;

create table roles(
	id int not null auto_increment,
    name varchar(20) not null unique,
    primary key(id)
);

create table users(
	id int not null auto_increment,
    username varchar(20) not null unique,
    email varchar(50),
    password varchar(120) not null,
    primary key(id)
);

create table user_roles(
	user_id int,
    role_id int,
    foreign key(user_id) references users(id),
    foreign key(role_id) references roles(id)
);

insert into roles(name) values ('ROLE_USER'), ('ROLE_MODERATOR'), ('ROLE_ADMIN');
-- password would be a encrypted String, if it is readable for human, the app would not allow the login