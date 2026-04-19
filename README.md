# API de Usuarios com Spring Boot

Repositorio GitHub: backend-user-api

API simples em Java para cadastrar, listar, atualizar e remover usuarios.

## Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL

## Como rodar

1. Crie o banco portfolio_db.
2. Ajuste usuario e senha em src/main/resources/application.properties.
3. Rode mvn spring-boot:run.
4. Acesse a API em http://localhost:8080.

## Endpoints

- GET /api/users
- GET /api/users/{id}
- POST /api/users
- PUT /api/users/{id}
- DELETE /api/users/{id}

## Testes simulados

| Cenario | Resultado esperado |
|---|---|
| Listar usuarios | 200 |
| Buscar usuario existente | 200 |
| Buscar usuario inexistente | 404 |
| Criar usuario | 201 |
| Atualizar usuario | 200 |
| Remover usuario | 204 |

## Evidencias

- print da API no Postman
- print dos status 200, 201, 204 e 404
- print do teste de validacao
