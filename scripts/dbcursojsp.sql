create database dbcursojsp;
use dbcursojsp;

create table tblogin(
login varchar(50) not null unique,
senha varchar(15) not null
);

select * from tblogin;
insert into tblogin( login, senha) values("rosana", "123456");
insert into tblogin( login, senha) values("admin", "admin");

alter table tblogin add id serial primary key;
alter table tblogin add nome varchar(300) not null;
alter table tblogin add email varchar(500) not null;

