# TinyLink API

Uma API simples e eficiente para encurtamento de URLs, desenvolvida com Java.

## 🚀 Tecnologias Utilizadas

* **Java 20**
* **Spring Boot:** Para a criação rápida da API.
* **PostgreSQL:** Banco de dados para persistência dos links.
* **JPA / Hibernate:** Para o mapeamento objeto-relacional com o banco de dados.
* **Maven:** Gerenciador de dependências.

## ⚙️ Como Executar o Projeto

1.  **Pré-requisitos:**
    * Ter o Java 20 (JDK) instalado.
    * Ter o Git instalado.
    * Ter o PostgreSQL instalado e rodando.

2.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/evandrohenrique01/TinyLink.git](https://github.com/evandrohenrique01/TinyLink.git)
    cd TinyLink
    ```

3.  **Configure o Banco de Dados:**
    * Crie um banco de dados vazio no seu PostgreSQL com o nome `tiny_link`.
    * Abra o arquivo `src/main/resources/application.properties`.
    * Altere as linhas `spring.datasource.username` e `spring.datasource.password` com o seu usuário e senha corretos do PostgreSQL.

4.  **Execute a aplicação:**
    * Abra o projeto no VS Code.
    * Navegue até o arquivo `ApiApplication.java` e clique no botão "Run" que aparece no editor.
    * A API estará rodando em `http://localhost:8080`.

## 📡 Como Usar a API

### 1. Encurtar uma URL

Envie uma requisição **POST** para a raiz da API com a URL no corpo da requisição.

* **Endpoint:** `POST /`
* **Corpo (Body) da Requisição (JSON):**
    ```json
    {
      "url": "[https://www.google.com/search?q=engenharia+de+computacao](https://www.google.com/search?q=engenharia+de+computacao)"
    }
    ```
* **Resposta de Sucesso (Exemplo):**
    ```json
    {
      "id": "b7b2a2a2",
      "shortUrl": "http://localhost:8080/b7b2a2a2"
    }
    ```

### 2. Acessar a URL Original

Basta acessar a `shortUrl` retornada no passo anterior diretamente no seu navegador.

* **Endpoint:** `GET /{id}`
* **Exemplo:** Acessar `http://localhost:8080/b7b2a2a2` no navegador irá te redirecionar para a URL original do Google.