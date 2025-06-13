-- V6: Tabela de não conformidades
CREATE TABLE nao_conformidade (
  id SERIAL PRIMARY KEY,
  etapa_id INT NOT NULL REFERENCES etapa_producao(id),
  operador_id INT NOT NULL REFERENCES operador(id),
  descricao TEXT NOT NULL,
  data_registro TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
);
