# TeamTask API

Projeto backend em **Java 17 + Spring Boot** para gerenciamento de usuários, com foco em cadastro e consulta.

## O que o projeto faz

A aplicação expõe endpoints HTTP para:
- registrar novos usuários (`/auth/register`);
- listar usuários com paginação e filtro por nome (`/users`);
- buscar usuário por ID (`/users/{id}`);
- buscar usuário por e-mail (`/users/email`).

Os dados são persistidos em **PostgreSQL** via **Spring Data JPA**, e o versionamento de schema é feito com **Flyway**.

## Stack principal

- Java 17
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Spring Security
- Flyway
- PostgreSQL
- Maven

## Segurança

- Senhas são criptografadas com **BCrypt**.
- A aplicação está configurada como **stateless**.
- No estado atual, as rotas `/auth/**` e `/users/**` estão liberadas (`permitAll`) para facilitar desenvolvimento inicial.

## Banco de dados

A migration inicial cria a tabela `users` com:
- `id` (UUID)
- `name`
- `email` (único)
- `password`
- `role`
- `create_at`

## Configuração

Defina as variáveis de ambiente:

- `DB_USERNAME`
- `DB_PASSWORD`

E ajuste, se necessário, a URL em `application.properties`:

`jdbc:postgresql://localhost:5432/team_task`

## Como executar

```bash
./mvnw spring-boot:run
```

A aplicação sobe na porta `8080`.
