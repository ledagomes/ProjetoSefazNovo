CREATE TABLE PESSOA(
    nome varchar(20) NOT NULL,
    cpf varchar(14) NOT NULL,
    idade integer NOT NULL,
    PRIMARY KEY (cpf) 
);


CREATE TABLE ENDERECO (
    id_endereco integer NOT NULL,
    rua varchar(50) NOT NULL,
    numero varchar(10) NOT NULL,
    compl varchar(20),
    cpf varchar(14) NOT NULL,
    PRIMARY KEY (id_endereco), 
    FOREIGN KEY (cpf) REFERENCES PESSOA
);

CREATE SEQUENCE S_ENDERECO 
	MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 1;








