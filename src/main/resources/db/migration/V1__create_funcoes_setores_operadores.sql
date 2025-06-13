-- V1: Tabelas de funções, setores e operadores
CREATE TABLE funcao (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(50) NOT NULL
);

CREATE TABLE setor (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(50) NOT NULL
);

CREATE TABLE operador (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  funcao_id INT NOT NULL REFERENCES funcao(id),
  setor_id INT NOT NULL REFERENCES setor(id),
  ativo BOOLEAN DEFAULT TRUE
);
