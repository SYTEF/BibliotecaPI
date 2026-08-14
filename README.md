<h1 align="center"> Sistema de Gerenciamento de Biblioteca</h1>

<p align="center">
  Aplicação desktop desenvolvida em Java para gerenciamento de livros,
  usuários, empréstimos e devoluções.
</p>

<p align="center">
  <code>Java</code> ·
  <code>Java Swing</code> ·
  <code>MySQL</code> ·
  <code>JDBC</code> ·
  <code>NetBeans</code>
</p>

---

> Projeto acadêmico desenvolvido durante a formação em Desenvolvimento de Sistemas, com foco na aplicação prática de orientação a objetos, interfaces gráficas, banco de dados relacional e integração Java/MySQL.

##  Objetivo do Projeto

Desenvolver uma aplicação desktop para gerenciamento de biblioteca, centralizando o controle de livros, usuários, empréstimos e devoluções.

O projeto foi utilizado para aplicar conceitos de desenvolvimento de software, orientação a objetos, persistência de dados e integração entre uma aplicação Java e um banco de dados MySQL.

---

##  Funcionalidades

###  Autenticação

* Login com usuário e senha
* Validação de acesso ao sistema

###  Gerenciamento de Livros

* Cadastro de novos livros
* Edição de informações
* Exclusão de livros
* Consulta e busca por título ou autor
* Controle de disponibilidade
* Identificação de livros disponíveis ou emprestados

###  Gerenciamento de Usuários

* Cadastro de usuários
* Edição de dados cadastrados
* Exclusão de usuários
* Busca por nome ou CPF
* Armazenamento de nome, CPF e e-mail

###  Empréstimos e Devoluções

* Registro de empréstimos
* Associação entre usuário e livro
* Consulta de empréstimos ativos
* Registro de devoluções
* Atualização automática da disponibilidade do livro

---

##  Tecnologias Utilizadas

| Tecnologia   | Aplicação no projeto                   |
| ------------ | -------------------------------------- |
| Java         | Desenvolvimento da aplicação           |
| Java Swing   | Construção das interfaces gráficas     |
| MySQL        | Banco de dados relacional              |
| JDBC         | Comunicação entre Java e MySQL         |
| NetBeans     | Desenvolvimento e construção das telas |
| Git / GitHub | Versionamento do projeto               |

---

##  Banco de Dados

O projeto utiliza **MySQL** para persistência das informações.

Principais tabelas:

* `livros`
* `usuarios`
* `emprestimos`

O script para criação da estrutura do banco está disponível no arquivo:

`biblioteca.sql`

A aplicação utiliza JDBC para realizar a comunicação entre o sistema Java e o banco de dados.

---

##  Estrutura da Aplicação

O projeto está organizado em classes responsáveis pelas entidades, acesso e manipulação dos dados e interfaces gráficas.

Principais componentes:

* `Conexao.java` — configuração e conexão com o banco de dados
* `Dados.java` — operações de persistência e manipulação dos dados
* `Livro.java` — representação dos livros
* `Usuario.java` — representação dos usuários
* `Emprestimo.java` — representação dos empréstimos
* `TelaLogin.java` — autenticação
* `TelaMenuPrincipal.java` — navegação principal
* `TelaLivros.java` — gerenciamento de livros
* `TelaUsuarios.java` — gerenciamento de usuários
* `TelaEmprestimos.java` — gerenciamento de empréstimos

---

##  Fluxo de Empréstimo

Um dos principais fluxos implementados no projeto é o controle do ciclo de empréstimo de um livro:

**Livro disponível → Empréstimo registrado → Livro indisponível → Devolução registrada → Livro disponível novamente**

Esse processo mantém o status do acervo sincronizado com as operações realizadas no sistema.

---

##  Como Executar

### Pré-requisitos

* Java JDK 8 ou superior
* NetBeans IDE
* MySQL Server 8.0
* MySQL Connector/J

### Configuração

1. Clone o repositório:

`git clone https://github.com/SYTEF/BibliotecaPI.git`

2. Abra o projeto no NetBeans.

3. Execute o arquivo `biblioteca.sql` no MySQL.

4. Configure os dados de conexão no arquivo:

`src/biblioteca/Conexao.java`

5. Execute o projeto pelo NetBeans.

---

##  Conhecimentos Aplicados

Durante o desenvolvimento deste projeto foram trabalhados conceitos de:

* Programação orientada a objetos
* Java
* Interfaces gráficas com Swing
* CRUD
* Banco de dados relacional
* SQL
* JDBC
* Integração Java/MySQL
* Regras de negócio
* Versionamento com Git e GitHub

---

##  Autor

**Enzo Borsato**

Desenvolvimento Java e Banco de Dados

Projeto desenvolvido durante a formação em **Técnico em Desenvolvimento de Sistemas — Senac-SP**.
