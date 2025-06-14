# Controle de Produção API

API REST para automação do controle de ordens de produção, operadores, setores, produtos e histórico de produção.

## 🚀 Tecnologias

* Java 17
* Spring Boot 3.5
* Spring Data JPA (Hibernate)
* Flyway para migrations SQL
* Lombok
* SpringDoc OpenAPI (Swagger UI)
* PostgreSQL 17
* Maven (wrapper incluso)

## 📋 Funcionalidades

* CRUD de **Funções**, **Setores**, **Operadores**, **Produtos**, **Ordens de Produção**, **Etapas de Produção**, **Estoque**, **Não Conformidades**, **Etiquetas QR** e **Histórico de Produção**.
* Registro automático de histórico de criação e alteração de ordens e etapas.
* Documentação interativa via Swagger UI.

## 🔧 Pré-requisitos

* JDK 17 instalado
* Docker (opcional)
* PostgreSQL 17 rodando local ou remoto
* Git

## ⚙️ Configuração

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/controle-producao-api.git
   cd controle-producao-api/api
   ```

2. Crie o banco e o usuário no PostgreSQL:

   ```sql
   CREATE DATABASE controle_producao;
   CREATE USER api_user WITH ENCRYPTED PASSWORD 'minha_senha';
   GRANT ALL PRIVILEGES ON DATABASE controle_producao TO api_user;
   -- Dentro do psql conectado à base:
   ALTER SCHEMA public OWNER TO api_user;
   GRANT USAGE, CREATE ON SCHEMA public TO api_user;
   ```

3. Crie o arquivo `.env` na raiz do projeto (mesmo nível do `pom.xml`):

   ```dotenv
   POSTGRES_HOST=localhost
   POSTGRES_PORT=5432
   POSTGRES_DB=controle_producao
   POSTGRES_USER=api_user
   POSTGRES_PASSWORD=minha_senha
   POSTGRES_DRIVER=org.postgresql.Driver
   ```

4. Verifique o arquivo `src/main/resources/application.properties` já contém:

   ```properties
   # importa variáveis do .env
   spring.config.import=optional:dotenv:./.env

   spring.datasource.url=jdbc:postgresql://${POSTGRES_HOST}:${POSTGRES_PORT}/${POSTGRES_DB}
   spring.datasource.username=${POSTGRES_USER}
   spring.datasource.password=${POSTGRES_PASSWORD}
   spring.datasource.driver-class-name=${POSTGRES_DRIVER}

   spring.jpa.hibernate.ddl-auto=none
   spring.flyway.enabled=true
   spring.flyway.locations=classpath:db/migration
   ```

## ⚙️ Banco de Dados e Migrations

As migrations SQL estão em `src/main/resources/db/migration`:

* V1 a V5: tabelas principais (função, setor, operador, produto, ordem, etapa, estoque)
* V6 a V8: tabelas adicionais (não conformidade, etiqueta\_qr, histórico\_producao)

O Flyway aplicará automaticamente ao iniciar a aplicação.

## 🛠️ Build e Execução

Utilizando o Maven Wrapper (não é necessária instalação global do Maven):

```bash
# Limpar e compilar
./mvnw clean install

# Rodar a aplicação
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

## 📖 Documentação da API

Após iniciar, acesse o Swagger UI em:

```
http://localhost:8080/swagger-ui.html
```

Lá você pode testar todos os endpoints:

* `/api/funcoes`
* `/api/setores`
* `/api/operadores`
* `/api/produtos`
* `/api/ordens`
* `/api/etapas`
* `/api/estoques`
* `/api/nao-conformidades`
* `/api/etiquetas-qr`
* `/api/historicos`

## 📦 Empacotamento

Para gerar um *jar* executável:

```bash
./mvnw clean package
java -jar target/controle-producao-api-0.0.1-SNAPSHOT.jar
```

## 🤝 Contribuição

Fork este repositório, crie uma branch com sua feature e abra um Pull Request.

## 📝 Licença

Este projeto está licenciado sob a **MIT License**. Veja [LICENSE](LICENSE) para mais detalhes.
