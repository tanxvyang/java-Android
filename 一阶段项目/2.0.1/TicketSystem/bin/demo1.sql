

create database db_demo1;

use db_demo1;
-----------t_user 表 ，实名制和注册要求id username password name id_number 不可为空
create table t_user(
	user_id int primary key auto_increment,  #用户 id
	username varchar(10) ,					#用户名
	password varchar(20),					#密码	
	name varchar(10) ,						#用户姓名
	phone_number varchar(11),				#电话号码
	id_number varchar(18),					#身份证号
	balance double,							#余额
	user_state varchar(3) 					#用户状态标识 1用户，2：管理员，3：封禁
	);
	
	
	#插入测试数据
	insert into t_user(username,password,name,phone_number,id_number,balance,user_state) values('user001','user001','锟斤铐','13188888888','610322201910310952',998,'1');
	insert into t_user values(2,'user010','user010','烫烫掏','18799999999','610322202009121002',null,'2');
	insert into t_user values(3,'user011','user011','老赖','1378747767','610322192009581031',10000,'3');
	
	
	
--------------------------------车票表--------------------------------------------------
create table  t_ticket(
	ticket_id int   primary key auto_increment,			#车票编号
	departure_station varchar(20)  ,					#起始站
	terminal_station varchar(20),						#终点站
	departure_time varchar(20),							#出发时间			
	ticket_number int,									#票数
	ticket_state varchar(3)	,							#车票状态 1 待售，2 开售，3 售空
	train_number varchar(10),             				#车次
	ticket_price double                      			#价格
	);
	
	
	
	
	insert into t_ticket values(1,'南京','上海','2019-12-11 12:10:00',1000,'1','K12');
	insert into t_ticket values(2,'上海','乌鲁木齐','2019-11-11 10:10:00',500,'2','Z42');
	insert into t_ticket values(3,'北京','上海','2019-11-02 12:10:00',0,'3','D888');
	insert into t_ticket values(4,'suzhou','nanghai','2019-11-11 12:10',43,'2','D12');
	insert into t_ticket values(5,'suhang','beihai','2019-11-23 12:10',222,'2','D28');
	insert into t_ticket values(6,'shandong','huahai','2019-11-03 12:10',232,'2','D12128');
	insert into t_ticket values(7,'shaoxing','adsfnghai','2019-11-02 12:10',44,'2','D8323');
	insert into t_ticket values(8,'baoji','shsdfi','2019-11-15 12:10',7,'2','D234');
	insert into t_ticket values(9,'xian','shangai','2019-12-9 12:10',100,'2','D823');
	insert into t_ticket values(10,'hanhong','shasdnghai','2019-12-22 12:10',145,'2','D123');
	
	insert into t_ticket (departure_station,terminal_station,departure_time,ticket_number,ticket_state,train_number,ticket_price)values('南京','上海','2019-12-11 12:10:00',1000,'1','K12',98);
	
	
	
	--------------------用户购票记录表-------------------------
create table t_record(
	record_id int primary key auto_increment, 						#编号
	user_id int references t_user(user_id),							#用户编号
	ticket_id int references t_ticket(ticket_id),					#车票编号
	train_number varchar(10)  references  t_ticket(train_number),  # 车次
	buy_time varchar(20),											#购买时间
	buy_state varchar(3)											#1 未付款，2 已付款，3 已退票
	);
	insert into t_record values(1,1,2,'2019-10-11 12:10','3');
	insert into t_record values(2,1,2,'2019-11-15 15:30','2');
	insert into t_record values(3,1,2,'2019-10-30 08:10','1');
	

	
	-----------------------充值申请表-----------------------------
create table t_recharge(
	recharge_id int  primary key auto_increment, 	#订单编号
	user_id int references t_user(user_id),			#用户编号
	username varchar references t_user(username)	#用户名
	apply_money double ,							#申请金额
 	apply_time varchar(20) ,						#申请时间
	apply_state varchar(3)							#申请状态 1：未处理，2：通过，3：驳回
	);
	
	
	insert into t_recharge values(1,1，'user010',2000,'2019-10-31 12:10:00','1');
	insert into t_recharge values(2,1，'user010',2000,'2019-10-31 13:10:00','2');
	insert into t_recharge values(3,1，'user010',2000,'2019-10-31 15:10:00','3');
