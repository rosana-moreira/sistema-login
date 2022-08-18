create database dbcursojsp;
use dbcursojsp;

create table tblogin(
login varchar(50) not null unique,
senha varchar(15) not null
);

select * from tblogin;

insert into tblogin( login, senha) values("rosana", "123456");
insert into tblogin( login, senha) values("admin", "admin");
