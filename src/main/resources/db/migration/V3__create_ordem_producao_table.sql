-- V3: Tabela de ordens de produção
CREATE TABLE ordem_producao (
  id SERIAL PRIMARY KEY,
  produto_id INT NOT NULL REFERENCES produto(id),
  quantidade INT NOT NULL,
  data_inicio TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
  data_fim TIMESTAMP WITHOUT TIME ZONE,
  status VARCHAR(20) NOT NULL
);
