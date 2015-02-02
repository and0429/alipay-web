create database alipay;

use alipay;

create table alipayLog(
	id_ varchar(32) primary key,
    oper_ int,
	operUser_ varchar(16),
    operDate_ timestamp,
    operChannel_ varchar(2),
    remark_ varchar(100)
    
)


create table oper(
	id_ int primary key,
    name_ varchar(12)
)

create table channel(
	id_ int primary key,
    name_ varchar(12)
)

insert into channel(id_,name_) values(1,'支付宝')；
insert into channel(id_,name_) values(2,'微信')；

insert into oper(id_,name_) values(1,'预下单');
insert into oper(id_,name_) values(2,'下单并支付');
insert into oper(id_,name_) values(3,'关闭');
insert into oper(id_,name_) values(4,'撤销');
insert into oper(id_,name_) values(5,'退款');
