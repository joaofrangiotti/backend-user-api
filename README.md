# API REST de Usuarios - Spring Boot

Projeto back-end em Java com Spring Boot para CRUD de usuarios, seguindo estrutura em camadas e boas praticas para portfolio.

Repositorio GitHub: `backend-user-api`

## Descricao do projeto

A API permite cadastrar, listar, atualizar e remover usuarios, com validacao basica dos dados e tratamento simples de erros.

## Tecnologias utilizadas

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Spring Validation
- MySQL
- Maven

## Estrutura do projeto

```text
src/main/java/com/portfolio/apiusers
|- controller
|- service
|- repository
|- model
|- exception
```

## Como rodar o projeto

1. Crie um banco MySQL chamado `portfolio_db`.
2. Ajuste usuario/senha no arquivo `src/main/resources/application.properties`.
3. Abra a pasta do projeto no terminal.
4. Execute:

```bash
mvn spring-boot:run
```

5. API disponivel em: `http://localhost:8080`

## Endpoints disponiveis

### GET - Listar usuarios

- `GET /api/users`
- Status esperado: `200`

### GET - Buscar usuario por id

- `GET /api/users/{id}`
- Status esperado: `200`
- Se nao existir: `404`

### POST - Criar usuario

- `POST /api/users`
- Status esperado: `201`

Exemplo de requisicao:

```json
{
  "nome": "Maria Silva",
  "email": "maria@email.com",
  "senha": "123456"
}
```

Exemplo de resposta:

```json
{
  "id": 1,
  "nome": "Maria Silva",
  "email": "maria@email.com",
  "senha": "123456"
}
```

### PUT - Atualizar usuario

- `PUT /api/users/{id}`
- Status esperado: `200`
- Se nao existir: `404`

### DELETE - Remover usuario

- `DELETE /api/users/{id}`
- Status esperado: `204`
- Se nao existir: `404`

## Tratamento de erros

A API retorna JSON de erro para:

- Recurso nao encontrado (`404`)
- Erro de validacao (`400`)
- Erro interno (`500`)

## Secao de testes

Voce pode testar com Postman usando os seguintes cenarios:

1. Criar usuario valido (esperado `201`).
2. Criar usuario com email invalido (esperado `400`).
3. Buscar usuario existente (`200`) e inexistente (`404`).
4. Atualizar usuario existente (`200`).
5. Remover usuario existente (`204`).

Para rodar teste basico de contexto:

```bash
mvn test
```

## Simulacao de execucao

Exemplo de saida esperada ao subir a API e testar os endpoints:

```text
GET /api/users            -> 200 OK
GET /api/users/1          -> 200 OK
POST /api/users           -> 201 Created
PUT /api/users/1          -> 200 OK
DELETE /api/users/1       -> 204 No Content
GET /api/users/999        -> 404 Not Found
POST /api/users (invalido)-> 400 Bad Request
```

Exemplo de retorno de erro:

```json
{
  "timestamp": "2026-04-19T10:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Usuario nao encontrado com id: 999"
}
```

Nota: os testes automatizados do projeto usam H2 em ambiente de teste para facilitar a execucao local.
