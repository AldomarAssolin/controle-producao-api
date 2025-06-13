-- V4: Tabela de etapas de produção
CREATE TABLE etapa_producao (
  id SERIAL PRIMARY KEY,
  ordem_id INT NOT NULL REFERENCES ordem_producao(id),
  setor_id INT NOT NULL REFERENCES setor(id),
  operador_id INT NOT NULL REFERENCES operador(id),
  status VARCHAR(20) NOT NULL,
  hora_inicio TIMESTAMP WITHOUT TIME ZONE,
  hora_fim TIMESTAMP WITHOUT TIME ZONE
);
