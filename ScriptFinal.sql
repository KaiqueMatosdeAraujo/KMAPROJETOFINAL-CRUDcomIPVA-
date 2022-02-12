create database crudcarros;

create  table  crudcarros.carro (
  idcarroSql int  not  null  auto_increment ,
  modelo VARCHAR(45) not  null ,
  ano varchar(4)  not null ,
  primary  key  (idcarroSql));

create table crudcarros.ipva (
  id int not null auto_increment ,
  ano varchar(4)  not null ,
  primary  key  (id));
 
 


select * from crudcarros.carro;

select * from crudcarros.ipva;
