# CRUD Java com Hibernate

Este projeto é um exemplo de aplicação CRUD (Create, Read, Update, Delete) usando Java, Hibernate e MySQL. Foi desenvolvido com o NetBeans.

## Funcionalidades

- Cadastro de usuários
- Atualização de dados
- Remoção de registros
- Listagem com Hibernate

## Tecnologias usadas

- Java
- Hibernate
- MySQL
- NetBeans

## 🎲 Banco de Dados

Este projeto usa **PostgreSQL**.

Antes de rodar o sistema, crie o banco de dados e suas tabelas usando o script: `script_criacao_banco.sql`

Você pode executá-lo no pgAdmin, DBeaver ou via terminal com o comando:

```bash
psql -U seu_usuario -d postgres -f script_criacao_banco.sql

Atenção: Ajuste o hibernate.cfg.xml com seu usuário, senha e porta do PostgreSQL

## Como rodar o projeto

1. Clone este repositório:
git clone https://github.com/CarlosMut24/CRUD_Java.git

2. Abra no NetBeans

3. Configure o banco de dados (`hibernate.cfg.xml`)

4. Execute a classe `Main` (ou a que inicia o app)

---

**Autor:** Carlos
