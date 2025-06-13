-- V2: Tabela de produtos
CREATE TABLE produto (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  codigo VARCHAR(50) UNIQUE NOT NULL,
  categoria VARCHAR(50),
  descricao TEXT
);
