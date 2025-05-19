# Workshop MongoDB
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Kiel025/workshop-springboot-mongodb/blob/main/LICENCE)

## Sobre o projeto

http://ec2-3-86-161-245.compute-1.amazonaws.com/swagger-ui/

Esse workshop é uma aplicação backend web construída durante o curso de Java completo do **Nélio Alves**, com outras features implementadas por mim.

A aplicação consiste em um sistema de gerenciamento de usuários, posts e comentários, onde é possível adicionar usuários e obter seus posts com os comentários.

## Documentação da API

![image](https://user-images.githubusercontent.com/51238981/205514168-340da970-58d7-4539-ac03-06bfbc8fcf97.png)
![image](https://user-images.githubusercontent.com/51238981/205514216-2a246a9a-c3c4-4150-9144-71357285f845.png)

## Tecnologias utilizadas

- Java 17
- Spring Boot 2.7.5
- MongoDB
- Maven
- Swagger UI

## Implantação em produção

- Amazon EC2
- Banco de dados: MongoDB Atlas

## Como executar o projeto

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


## Autor

Ezequiel Sousa Santos

https://www.linkedin.com/in/ezequielssantos/
