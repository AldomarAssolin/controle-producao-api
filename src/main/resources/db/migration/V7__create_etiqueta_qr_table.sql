-- V7: Tabela de etiquetas QR
CREATE TABLE etiqueta_qr (
  id SERIAL PRIMARY KEY,
  codigo VARCHAR(100) NOT NULL UNIQUE,
  ordem_id INT REFERENCES ordem_producao(id),
  produto_id INT REFERENCES produto(id),
  data_criacao TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
);
