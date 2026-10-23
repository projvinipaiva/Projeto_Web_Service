# Projeto Web Service - API REST com Spring Boot e JPA/Hibernate

> **"Do modelo de domínio ao CRUD completo: uma API REST em camadas, do jeito certo!"** 🚀

Bem-vindo ao repositório do **Projeto Web Service**! Este projeto foi desenvolvido para praticar e consolidar o desenvolvimento de **APIs REST em Java**, aplicando boas práticas de arquitetura em camadas, mapeamento objeto-relacional com JPA/Hibernate e tratamento de exceções. A especificação segue o curso *Java COMPLETO* da DevSuperior (Prof. Nelio Alves).

---

## 📖 Sobre o Projeto

O Projeto Web Service é uma API de **gerenciamento de pedidos (e-commerce)**. A aplicação modela usuários, pedidos, itens de pedido, produtos, categorias e pagamentos, expondo os dados por meio de endpoints REST em formato JSON.

O objetivo é construir, passo a passo, um back-end organizado e fácil de manter, no qual seja possível:

- 🏗️ Estruturar a aplicação em camadas lógicas (**resource**, **service** e **repository**).
- 🗄️ Mapear um modelo de domínio real com associações JPA (um-para-muitos, muitos-para-muitos e um-para-um).
- 🔁 Realizar operações de **CRUD** (Create, Retrieve, Update, Delete).
- 🛡️ Tratar erros de forma padronizada, com respostas claras para o cliente da API.

---

## ✨ Funcionalidades

- 👤 **CRUD de usuários**: cadastro, consulta, atualização e remoção.
- 🧾 **Pedidos**: consulta de pedidos com status (`WAITING_PAYMENT`, `PAID`, `SHIPPED`, `DELIVERED`, `CANCELED`) e cliente associado.
- 🛍️ **Produtos e categorias**: consulta de produtos e de suas categorias (associação muitos-para-muitos).
- 📦 **Itens de pedido**: associação entre pedido e produto com atributos extras (quantidade e preço), com cálculo de **subtotal** e **total** do pedido.
- 💳 **Pagamento**: associação um-para-um com o pedido.
- ⚠️ **Tratamento de exceções**: handler global com resposta de erro padronizada para recurso não encontrado e violação de integridade no banco.
- 🧪 **Banco de teste (H2)** com carga inicial de dados (seed) e console web.
- 🐘 **Perfil de desenvolvimento** com PostgreSQL.

---

## 🧩 Modelo de Domínio

| Entidade | Principais atributos | Relacionamentos |
|---|---|---|
| `User` | id, name, email, phone, password | 1 usuário → N pedidos |
| `Order` | id, moment, orderStatus | N pedidos → 1 usuário; 1 pedido → N itens; 1 pedido → 0..1 pagamento |
| `OrderItem` | quantity, price | Associação Pedido ↔ Produto |
| `Product` | id, name, description, price, imgUrl | N produtos ↔ N categorias |
| `Category` | id, name | N categorias ↔ N produtos |
| `Payment` | id, moment | 1 pagamento → 1 pedido |

---

## 🏛️ Arquitetura em Camadas

```
Application
    ↕
Resource Layer (REST controllers)
    ↓
Service Layer
    ↓
Data Access Layer (repositories)         Entities
```

```
src/main/java/.../
 ├── config/                 # Configuração do perfil de teste e carga inicial (seed)
 ├── entities/               # Entidades JPA e enum OrderStatus
 ├── repositories/           # Interfaces JpaRepository
 ├── services/               # Regras de negócio
 │    └── exceptions/        # ResourceNotFoundException, DatabaseException
 └── resources/              # Controllers REST
      └── exceptions/        # StandardError, ResourceExceptionHandler
```

---

## 🔌 Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/users` | Lista todos os usuários |
| `GET` | `/users/{id}` | Busca um usuário por id |
| `POST` | `/users` | Cadastra um novo usuário |
| `PUT` | `/users/{id}` | Atualiza um usuário |
| `DELETE` | `/users/{id}` | Remove um usuário |
| `GET` | `/orders` e `/orders/{id}` | Consulta pedidos |
| `GET` | `/products` e `/products/{id}` | Consulta produtos |
| `GET` | `/categories` e `/categories/{id}` | Consulta categorias |

**Exemplo de corpo para `POST /users`:**

```json
{
  "name": "Bob Brown",
  "email": "bob@gmail.com",
  "phone": "977557755",
  "password": "123456"
}
```

---

## 🛠️ Tecnologias Utilizadas

Este projeto foi desenvolvido com as seguintes tecnologias:

* **Linguagem:** Java
* **Framework:** Spring Boot (Spring Web e Spring Data JPA)
* **ORM:** JPA / Hibernate
* **Gerenciador de dependências:** Maven
* **Banco de dados:** H2 (perfil de teste) e PostgreSQL (perfil de desenvolvimento)
* **Testes de requisições:** Postman
* **Versionamento:** Git e GitHub

---

## ▶️ Como Executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/projvinipaiva/Projeto_Web_Service.git
   cd Projeto_Web_Service
   ```

2. Execute a aplicação (perfil `test` com H2 em memória):

   ```bash
   ./mvnw spring-boot:run
   ```

3. Acesse a API em `http://localhost:8080/users`.

4. (Opcional) Acesse o console do H2 em `http://localhost:8080/h2-console` com a URL `jdbc:h2:mem:testdb` e o usuário `sa`.

> 💡 Para usar o PostgreSQL localmente, crie o banco e configure o perfil `dev` no arquivo `application-dev.properties`.

---

## 👨‍💻 Autor

**Vinícius de Paiva Mendonça Silva**
Estudante de Análise e Desenvolvimento de Sistemas (FATEC São Caetano do Sul)

🔗 [github.com/projvinipaiva](https://github.com/projvinipaiva)
