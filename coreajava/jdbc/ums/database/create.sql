create database ums charset=utf8;
use ums
create table t_user(
	id int primary key auto_increment,
	username varchar(10),
	password varchar(50),
	phone varchar(20),
	regist_date date,
	status int
);