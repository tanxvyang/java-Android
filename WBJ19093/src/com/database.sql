create table t_user(
	uid  int  primary key auto_increment,
	username varchar(10),
	password varchar(20),
	usermoney double
);
insert into t_user values(null,'user1','123',0.0)
create table t_good(
	gid int primary key auto_increment,
	goodname varchar(20),
	goodprice double,
	goodintro varchar(200)
);
insert into t_good values
(null,'good1',1.0,'this is good1'),
(null,'good2',15.0,'this is good2'),
(null,'good3',10.0,'this is good3');


alter table t_good add nums int;


















