insert into Endereco values(1,'Rua dos Desenvolvedores mobile', '14', 'complemento 14', 'vizinhanca dos dev mobile', 'Brasilia', 'DF', 'Brasil', '72660074', null, null);
insert into Endereco values (2,'Rua dos Desenvolvedores Desktop', '19', 'complemento 19', 'vizinhanca dos dev desktop', 'Taguatinga', 'DF', 'Brasil', '70000000', '1248S', '04456W');
insert into Endereco values (3,'Rua dos Desenvolvedores Java', '77', 'complemento 77', 'vizinhanca dos dev Java', 'Sudoeste', 'DF', 'Brasil', '76000455', '2098S','04456W');
insert into Endereco values (4,'Rua dos Desenvolvedores Angular', '80', 'complemento 80', 'vizinhanca dos dev Angular', 'Noroeste', 'DF', 'Brasil', '72900087', '2065S', '04265W');
CREATE SEQUENCE ENDERECO_SEQUENCE_ID START WITH (select max(ID) + 1 from Endereco);