create table Endereco
(
   id integer not null,
   streetName varchar(255) not null,
   numero varchar(255) not null,
   complement varchar(255),
   neighbourhood varchar(255) not null,
   city varchar(255) not null,
   state varchar(200) not null,
   country varchar(200) not null,
   zipCode varchar(20) not null,
   latitude varchar(40),
   longitude varchar(40),
   primary key(id)
);