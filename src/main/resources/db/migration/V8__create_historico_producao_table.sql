-- V8: Tabela de histórico de produção
CREATE TABLE historico_producao (
  id SERIAL PRIMARY KEY,
  ordem_id INT NOT NULL REFERENCES ordem_producao(id),
  status_anterior VARCHAR(20) NOT NULL,
  status_novo VARCHAR(20) NOT NULL,
  data_alteracao TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
  alterado_por INT REFERENCES operador(id)
);
