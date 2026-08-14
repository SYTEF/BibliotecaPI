## Status do Projeto
**Em Desenvolvimento**

---

<h1 align="center"> Sistema de Gerenciamento de Biblioteca</h1>

<p align="center">
  Aplicação desktop desenvolvida em Java para gerenciamento de livros,
  usuários, empréstimos e devoluções.
</p>

<p align="center">
  <code>Java</code> ·
  <code>Java Swing</code> ·
  <code>MySQL</code> ·
  <code>JDBC</code>
</p>

---

> Projeto acadêmico desenvolvido durante a formação em Desenvolvimento de Sistemas, com foco em orientação a objetos, banco de dados e integração Java/MySQL.

---

##  Time de Desenvolvedores
| Nome | Função |
|------|--------|
| Enzo Borsato | Desenvolvimento Java e Banco de Dados|

---

##  Objetivo do Projeto

Desenvolver uma aplicação desktop para gerenciamento de biblioteca, aplicando na prática conceitos de orientação a objetos, interface gráfica, banco de dados relacional e integração Java/MySQL.

O sistema permite centralizar o controle de livros, usuários, empréstimos e devoluções, aplicando regras de negócio como disponibilidade automática do acervo durante o ciclo de empréstimo.

---

##  Funcionalidades do Sistema

###  Autenticação

* Login de acesso ao sistema
* Validação de usuário e senha
* Controle de acesso às funcionalidades da aplicação

###  Gerenciamento de Livros

* Cadastro de livros com título, autor e categoria
* Consulta e busca por título ou autor
* Edição das informações cadastradas
* Exclusão de livros do acervo
* Controle de disponibilidade entre **disponível** e **emprestado**

###  Gerenciamento de Usuários

* Cadastro de usuários com nome, CPF e e-mail
* Consulta e busca por nome ou CPF
* Atualização dos dados cadastrados
* Exclusão de usuários

###  Empréstimos e Devoluções

* Registro de empréstimos vinculando livro e usuário
* Consulta de empréstimos ativos
* Registro de devolução
* Atualização automática da disponibilidade do livro após empréstimo ou devolução

---

## Banco de Dados
- Banco: **MySQL**
- Tabelas: `livros`, `usuarios`, `emprestimos`
- Script de criação disponível no arquivo `biblioteca.sql`

---

## Como Executar o Projeto

### Pré-requisitos
- Java JDK 8 ou superior
- NetBeans IDE
- MySQL Server 8.0
- MySQL Connector/J (driver JDBC)

### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/BibliotecaPI.git
   ```
2. Importe o projeto no NetBeans
3. Execute o script `biblioteca.sql` no MySQL Workbench
4. Configure a conexão em `src/biblioteca/Conexao.java`
5. Execute o projeto pelo NetBeans

---

## Estrutura do Projeto
```
BibliotecaPI/
├── src/
│   └── biblioteca/
│       ├── Conexao.java
│       ├── Dados.java
│       ├── Livro.java
│       ├── Usuario.java
│       ├── Emprestimo.java
│       ├── TelaLogin.java / .form
│       ├── TelaMenuPrincipal.java / .form
│       ├── TelaLivros.java / .form
│       ├── TelaUsuarios.java / .form
│       └── TelaEmprestimos.java / .form
├── biblioteca.sql
└── README.md
```
