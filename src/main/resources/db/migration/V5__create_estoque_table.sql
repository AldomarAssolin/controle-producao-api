-- V5: Tabela de estoque
CREATE TABLE estoque (
  id SERIAL PRIMARY KEY,
  produto_id INT NOT NULL REFERENCES produto(id),
  quantidade_atual INT NOT NULL DEFAULT 0
);
