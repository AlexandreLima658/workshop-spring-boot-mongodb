# API Java Spring com MongoDB


Este projeto consiste em um API desenvolvida em **Java** utilizando o framework **Spring Boot**, com o banco de dados 
**MongoDB**, **Swagger** para documentação e **Docker** para a execução do banco de dados



## 📌 Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot**
- **Spring Data MongoDB**
- **Swagger (Springdoc OpenAPI)**
- **Docker e Docker Compose**
- **Gradle**

## 🚀 Como Executar o projeto

1. Clonar o repositório
```
 git clone https://github.com/AlexandreLima658/workshop-spring-boot-mongodb.git
```
2. Subir o banco de dados com o docker

```
 docker compose up -d
```
3. Configurar o application.yml
```
spring:
   data:
      mongodb:
         uri: mongodb://localhost:27017/seu-database       
```
4. Executar a aplicação

```
gradle bootRun       
```
## 🚀 Contribuição

Caso queira contribuir com este projeto, sinta-se à vontade para abrir issues ou enviar pull requests.
