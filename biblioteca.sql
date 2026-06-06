-- =============================================
-- Script SQL - Sistema de Gerenciamento de Biblioteca
-- Projeto Integrador - UC 10
-- Banco de Dados: MySQL 8.0
-- =============================================

-- Criação e seleção do banco
CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

-- =============================================
-- TABELA: livros
-- =============================================
CREATE TABLE IF NOT EXISTS livros (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    titulo      VARCHAR(100) NOT NULL,
    autor       VARCHAR(100) NOT NULL,
    categoria   VARCHAR(50),
    disponivel  BOOLEAN DEFAULT TRUE
);

-- =============================================
-- TABELA: usuarios
-- =============================================
CREATE TABLE IF NOT EXISTS usuarios (
    id    INT AUTO_INCREMENT PRIMARY KEY,
    nome  VARCHAR(100) NOT NULL,
    cpf   VARCHAR(20)  NOT NULL,
    email VARCHAR(100)
);

-- =============================================
-- TABELA: emprestimos
-- =============================================
CREATE TABLE IF NOT EXISTS emprestimos (
    id               INT AUTO_INCREMENT PRIMARY KEY,
    livro_id         INT NOT NULL,
    usuario_id       INT NOT NULL,
    data_emprestimo  DATE NOT NULL,
    status           VARCHAR(20) DEFAULT 'ATIVO',
    FOREIGN KEY (livro_id)    REFERENCES livros(id),
    FOREIGN KEY (usuario_id)  REFERENCES usuarios(id)
);

-- =============================================
-- DADOS INICIAIS: livros
-- =============================================
INSERT INTO livros (titulo, autor, categoria) VALUES
    ('Clean Code',               'Robert C. Martin', 'Programacao'),
    ('Java: Como Programar',     'Deitel',            'Programacao'),
    ('O Senhor dos Aneis',       'Tolkien',           'Fantasia'),
    ('Dom Casmurro',             'Machado de Assis',  'Literatura Brasileira'),
    ('O Cortico',                'Aluisio Azevedo',   'Literatura Brasileira'),
    ('Vidas Secas',              'Graciliano Ramos',  'Literatura Brasileira');

-- =============================================
-- DADOS INICIAIS: usuarios
-- =============================================
INSERT INTO usuarios (nome, cpf, email) VALUES
    ('Ana Silva',    '111.222.333-44', 'ana@email.com'),
    ('Carlos Souza', '555.666.777-88', 'carlos@email.com'),
    ('Maria Oliveira','999.888.777-66', 'maria@email.com');

-- =============================================
-- DADOS INICIAIS: emprestimos
-- =============================================
INSERT INTO emprestimos (livro_id, usuario_id, data_emprestimo, status) VALUES
    (1, 1, CURDATE(), 'ATIVO'),
    (3, 2, CURDATE(), 'ATIVO');

-- Marca livros emprestados como indisponíveis
UPDATE livros SET disponivel = FALSE WHERE id IN (1, 3);

-- =============================================
-- Verificação final
-- =============================================
SELECT 'Livros:'    AS '', COUNT(*) AS total FROM livros
UNION ALL
SELECT 'Usuarios:', COUNT(*) FROM usuarios
UNION ALL
SELECT 'Emprestimos:', COUNT(*) FROM emprestimos;
