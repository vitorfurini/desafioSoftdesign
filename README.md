# desafio para fins de avaliação

<h2> Descrição</h2>
O projeto foi desenvolvido para gerenciar livros em uma base de dados não relacional. Foram criados endpoints para criação, edição, deleção, busca por id, busca por filtros.

As tecnologias utilizadas foram:
- Java 11
- Spring Boot
- Maven
- Junit 5
- MongoDB
- Swagger
- Docker
- API Rest
- Lombok

<h2>Execução do projeto</h2>

Para compilar o projeto, execute o camando: mvn clean install

Para executar o projeto é necessário uma instância do docker rodando com um banco local do mongoDB

Para acessar os endpoints criados, acesse: http://localhost:8080/swagger-ui.html

A lista de requisições que podem ser feitas no projeto são:

Para listar todos os livros cadastrados na base:
- GET /api/books/

Para buscar um livro por id:
- GET /api/books/{id}

Para buscar vários livros por nome do author:
- GET /api/books/findByAuthor/{authorName}

Para buscar livros por nome:
- GET /api/books/findByname/{name}

Para criar um livro:
- POST /api/crud/books

Para atualizar um livro pelo id:
- PUT /api/crud/books/{id}

Para excluir um livro pelo id:
- DELETE /api/crud/books/delete/{id}

Para atualizar a flag de alugado ou não:
- PUT /api/crud/books/updateRented/{id}


Para mais detalhes, entrar em contato: https://www.linkedin.com/in/vitor-furini/
