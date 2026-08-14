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

## Objetivo do Software
O Sistema de Gerenciamento de Biblioteca tem como objetivo automatizar e organizar as operações de uma biblioteca, permitindo o controle de acervo de livros, cadastro de usuários e gerenciamento de empréstimos e devoluções, substituindo processos manuais por um sistema digital eficiente.

---

## Funcionalidades do Sistema

### Autenticação
- Login com usuário e senha
- Controle de acesso ao sistema

### Gerenciamento de Livros
- Cadastrar novos livros (título, autor, categoria)
- Editar informações de livros existentes
- Excluir livros do acervo
- Consultar e buscar livros por título ou autor
- Controle de disponibilidade (disponível / emprestado)

### Gerenciamento de Usuários
- Cadastrar novos usuários (nome, CPF, e-mail)
- Editar dados de usuários
- Excluir usuários
- Buscar usuários por nome ou CPF

### Empréstimos e Devoluções
- Registrar novo empréstimo vinculando livro e usuário
- Listar empréstimos ativos
- Registrar devolução de livros
- Atualização automática da disponibilidade do livro

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
