-- Cria o banco de dados (se ainda não existir)
CREATE DATABASE IF NOT EXISTS crud_hibernate;

create table if not exists PESSOA(
PES_codigo serial not null,
PES_nome varchar(80) not null,
PES_fantasia varchar(80),
PES_fisica char(1) not null,
PES_CpfCnpj varchar(20) not null,
PES_rgie varchar(20),
PES_cadrastro date,
PES_endereco varchar(120),
PES_numero varchar(10),
PES_complemento varchar(30),
PES_bairro varchar(50),
PES_cidade varchar(80),
PES_uf char(2),
PES_cep varchar(9),
PES_fone1 varchar(16), 
PES_fone2 varchar(16),
PES_celular varchar(16),
PES_site varchar(200),
PES_email varchar(200),
PES_ativo char(1)
);

create table if not exists CLIENTE(
CLI_codigo serial not null,
PES_codigo integer not null unique,
CLI_LimiteCred numeric(18,2)
);

create table if not exists FORNECEDOR(
FOR_codigo serial not null,
PES_codigo integer not null unique,
FOR_contato varchar(80)
);

create table if not exists USUARIO(
USU_codigo serial not null,
USU_nome varchar(80),
USU_login varchar(20) not null,
USU_senha varchar(20),
USU_cadrastro date,
USU_ativo char(1)
);

create table if not exists VENDA(
VDA_codigo serial not null,
USU_codigo integer not null,
CLI_codigo integer not null,
VDA_date date not null,
VDA_valor numeric(18,2), 
VDA_desconto numeric(18,2),
VDA_total numeric(18,2), 
VDA_OBS text
);

create table if not exists COMPRA(
CPR_codigo serial not null,
USU_codigo integer not null,
FOR_codigo integer not null,
CPR_emissao date,
CPR_valor numeric(18,2), 
CPR_desconto numeric(18,2), 
CPR_total numeric(18,2), 
CPR_dtentrada date,
CPR_OBS text
);

create table if not exists PRODUTO(
PRO_codigo serial not null,
PRO_nome varchar not null,
PRO_estoque numeric(18,2),
PRO_unidade varchar(5),
PRO_preco numeric(18,2),
PRO_custo numeric(18,2),
PRO_atacado numeric(18,2),
PRO_min numeric(14,4),
PRO_max numeric(14,4),
PRO_embalagem decimal(9,0),
PRO_peso numeric(14,4),
PRO_cadastro date,
PRO_OBS text,
PRO_ativo char(1)
);

create table if not exists VENDA_PRODUTO(
VEP_codigo serial not null,
VDA_codigo integer not null,
PRO_codigo integer not null,
VEP_qtde numeric(14,4),
VEP_preco numeric(18,2),
VEP_desconto numeric(18,2),
VEP_total numeric(18,2)
);

create table if not exists COMPRA_PRODUTO(
CPP_codigo serial not null,
CPR_codigo integer not null,
PRO_codigo integer not null,
CPP_qtde numeric(14,4) not null,
CPP_preco numeric(18,2) not null,
CPP_desconto numeric(18,2),
CPP_total numeric(18,2)
);

create table if not exists FORMAPAGTO(
FPG_codigo serial not null,
FPG_nome varchar(80) not null,
FPG_ativo char(1)
);

create table if not exists VENDA_PAGTO(
VDP_codigo serial not null,
VDA_codigo integer not null,
FPG_codigo integer not null,
VDP_valor numeric(18,2)
);


/*DECLARAÇÂO DE PK*/

alter table PESSOA add primary key (PES_codigo);

alter table CLIENTE add primary key (CLI_codigo);

alter table FORNECEDOR add primary key (FOR_codigo);

alter table USUARIO add primary key (USU_codigo);

alter table VENDA add primary key (VDA_codigo);

alter table COMPRA add primary key (CPR_codigo);

alter table PRODUTO add primary key (PRO_codigo);

alter table VENDA_PRODUTO add primary key (VEP_codigo);

alter table COMPRA_PRODUTO add primary key (CPP_codigo);

alter table FORMAPAGTO add primary key (FPG_codigo);

alter table VENDA_PAGTO add primary key (VDP_codigo);


/*DECLARAÇÂO DE FK*/

alter table CLIENTE add constraint "FK_CLIENTE_PESSOA"
	foreign key (PES_codigo) references PESSOA(PES_codigo);

alter table FORNECEDOR add constraint "FK_FORNECEDOR_PESSOA"
	foreign key (PES_codigo) references PESSOA(PES_codigo);

alter table VENDA add constraint "FK_VENDA_USUARIO"
	foreign key (USU_codigo) references USUARIO(USU_codigo);

alter table VENDA add constraint "FK_VENDA_CLIENTE"
	foreign key (CLI_codigo) references CLIENTE(CLI_codigo);

alter table COMPRA add constraint "FK_COMPRA_FORNECEDOR"
	foreign key (FOR_codigo) references FORNECEDOR(FOR_codigo);

alter table COMPRA add constraint "FK_COMPRA_USUARIO"
	foreign key (USU_codigo) references USUARIO(USU_codigo);

alter table VENDA_PRODUTO add constraint "FK_VENDA_PRODUTO_PRODUTO"
	foreign key (PRO_codigo) references PRODUTO(PRO_codigo);

alter table VENDA_PRODUTO add constraint "FK_VENDA_PRODUTO_VENDA"
	foreign key (VDA_codigo) references VENDA(VDA_codigo);

alter table COMPRA_PRODUTO add constraint "FK_COMPRA_PRODUTO_PRODUTO"
	foreign key (PRO_codigo) references PRODUTO(PRO_codigo);

alter table COMPRA_PRODUTO add constraint "FK_COMPRA_PRODUTO_COMPRA"
	foreign key (CPR_codigo) references COMPRA(CPR_codigo);

alter table VENDA_PAGTO add constraint "FK_VENDA_PAGTO_VENDA"
	foreign key (VDA_codigo) references VENDA(VDA_codigo);

alter table VENDA_PAGTO add constraint "FK_VENDA_PAGTO_FORMAPAGTO"
	foreign key (FPG_codigo) references FORMAPAGTO(FPG_codigo);