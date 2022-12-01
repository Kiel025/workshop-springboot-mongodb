# Workshop MongoDB
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Kiel025/workshop-springboot-mongodb/blob/main/LICENCE)

>Status: em progresso ⚠️

## Sobre o projeto

<hr>

http://ec2-18-204-218-183.compute-1.amazonaws.com/swagger-ui/

Esse workshop é uma aplicação backend web construída durante o curso de Java completo do **Nélio Alves**, com outras features implementadas por mim.

A aplicação consiste em um sistema de gerenciamento de usuários, posts e comentários, onde é possível adicionar usuários e obter seus posts com os comentários.

## Tecnologias utilizadas
<hr>

- Java
- Spring Boot
- MongoDB
- Maven
- Swagger UI

## Implantação em produção

<hr>

- Amazon EC2
- Banco de dados: MongoDB Atlas

## Como executar o projeto

<hr>

Pré-requisitos: Java 17, Mongod


```bash
# Antes de tudo, é necessário rodar o banco de dados local com o mongod
mongod --dbpath=<Sua pasta onde estão armazenados os banco de dados> --port 27017 | jq

# Em outra aba do terminal, clone repositório
git clone https://github.com/Kiel025/workshop-springboot-mongodb.git

# Entre na pasta do projeto
cd workshopmongo

# Execute o projeto
./mvnw spring-boot:run
```


# Autor

Ezequiel Sousa Santos

https://www.linkedin.com/in/ezequielssantos/
