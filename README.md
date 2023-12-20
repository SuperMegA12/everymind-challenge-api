# Nunes Sports API

Este projeto é uma API em Spring Boot para o EveryMind Challenge no qual deve-se criar uma aplicação CRUD fullstack para um cliente fictício chamado Nunes Sports. Esse cliente deve ser capaz de realizar operações CRUD nos seus produtos. 

A API foi dividida em várias camadas para melhor organização e manutenção.

## Estrutura do Projeto

### 1. Controllers

- **Descrição:** Contém as classes responsáveis por receber as requisições HTTP, direcionar para os serviços correspondentes e retornar as respostas apropriadas.

### 2. DTOs (Data Transfer Objects)

- **Descrição:** Contém classes que representam objetos de transferência de dados entre as camadas da aplicação. Esses objetos são usados para evitar a exposição de detalhes internos e fornecer uma visão simplificada dos dados.

#### 2.1 Product DTOs

##### 2.1.1 ProductRequestDTO

Classe utilizada para receber dados de entrada ao criar ou atualizar um produto.

- **Atributos:**
  - `name`: Nome do produto.
  - `code`: Código único do produto.
  - `description`: Descrição do produto.
  - `price`: Preço do produto.

##### 2.1.2 ProductResponseDTO

Classe utilizada para enviar dados de saída ao recuperar detalhes de um produto.

- **Atributos:**
  - `name`: Nome do produto.
  - `code`: Código único do produto.
  - `description`: Descrição do produto.
  - `price`: Preço do produto.

### 3. Models

- **Descrição:** Classes que representam as entidades principais da aplicação. Geralmente, essas classes estão diretamente relacionadas às tabelas do banco de dados.

#### 3.1 Product Model

A classe `Product` representa um produto na aplicação.

- **Atributos:**
  - `id`: Identificador único do produto (gerado automaticamente).
  - `name`: Nome do produto.
  - `code`: Código único do produto (deve ser único no banco de dados).
  - `description`: Descrição do produto.
  - `price`: Preço do produto.

### 4. Services / Use Cases

- **Descrição:** Contém as classes de serviço que implementam a lógica de negócios da aplicação. Cada serviço pode representar um caso de uso específico.

#### 4.1 Product Use Cases

##### 4.1.1 CreateProduct

Serviço responsável por criar um novo produto.

- **Entrada:**
  - `ProductRequestDTO`: DTO contendo informações do novo produto.

- **Saída:**
  - `Product`: Produto criado e salvo no banco de dados.

#### 4.1.2 LoadAllProducts

Serviço responsável por carregar todos os produtos existentes.

- **Saída:**
  - `List<Product>`: Lista de todos os produtos.

#### 4.1.3 LoadProduct

Serviço responsável por carregar um produto com base no código.

- **Entrada:**
  - `Long code`: Código do produto a ser carregado.

- **Saída:**
  - `Product`: Produto correspondente ao código fornecido.

#### 4.1.4 UpdateProduct

Serviço responsável por atualizar um produto existente.

- **Entrada:**
  - `Long id`: Identificador do produto a ser atualizado.
  - `ProductRequestDTO`: DTO contendo as informações atualizadas do produto.

- **Saída:**
  - `Product`: Produto atualizado e salvo no banco de dados.

#### 4.1.5 DeleteProduct

Serviço responsável por excluir um produto existente.

- **Entrada:**
  - `Long id`: Identificador do produto a ser excluído.

- **Ação:**
  - O serviço busca o produto com base no ID fornecido.
  - Se o produto não for encontrado, uma exceção é lançada.
  - Caso contrário, o produto é removido do banco de dados.

### 4. Services / Utils

- **Descrição:** Contém classes utilitárias que podem ser usadas em várias partes da aplicação.

#### 4.2 EntityMapper

Classe utilitária para mapeamento entre entidades e DTOs usando o ModelMapper.

- **Métodos:**
  - `mapToDto(S source, Class<D> destinationType)`: Realiza o mapeamento de uma entidade para um DTO.
  - `mapToEntity(S source, Class<D> destinationType)`: Realiza o mapeamento de um DTO para uma entidade.


### 5. Repositories

- **Descrição:** Classes responsáveis pela interação com o banco de dados. Cada repositório está associado a uma entidade e fornece métodos para realizar operações de leitura e gravação no banco de dados.

#### 5.1 ProductRepository

Repositório responsável pela interação com a entidade `Product`.

- **Métodos:**
  - `findByCode(Long code)`: Busca um produto com base no código fornecido.

Este repositório estende `JpaRepository`, fornecendo métodos comuns para operações CRUD (Create, Read, Update, Delete) em relação à entidade `Product`. O método adicional `findByCode` permite a busca de um produto específico com base no código.



## Dependências Principais

- **spring-boot-starter-data-jpa:** Fornecer suporte para operações de banco de dados usando o Spring Data JPA.
- **spring-boot-starter-web:** Suporte para desenvolvimento de aplicativos da web usando o Spring MVC.
- **h2:** Banco de dados em memória para desenvolvimento e teste.
- **lombok:** Biblioteca para reduzir a verbosidade do código Java.
- **validation-api:** API de validação para garantir a integridade dos dados.
- **modelmapper:** Facilita a conversão de objetos de um tipo para outro.
- **spring-boot-starter-test:** Conjunto de dependências para testes.

## Como Executar o Projeto

1. Clone o repositório.
2. Abra o projeto em sua IDE preferida.
3. Execute a classe principal: `NunesSportsApiApplication`.
4. A aplicação estará disponível em [http://localhost:8080](http://localhost:8080).

