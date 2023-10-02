# Banco Digital Descomplicado 🏦💻🤝 
O objetivo deste projeto foi desenvolver um protótipo de backend de um banco digital com a criação de conta e uso das funcionalidades de forma simplificada. Foi implementada usando a linguagem Java e Spring Framework além de diversas ferramentas e bibliotecas. Foram aplicados boas práticas de desenvolvimento, bem como princípios SOLID.
Tabém foi usando o módulo Spring Security e autenticação por Token(JWT) para garantir a segurança da aplicação.


# Índice
- Funcionalidades
- Regra de Negócios
- Tecnologias, bibliotecas e ferramentas utilizadas
- Arquitetura
- Como rodar
## Funcionalidades 🛠️
- [x] Cadastrar e Excluir conta
- [x] Realizar depósito
- [x] Realizar transferências
- [x] Salvar Conta como favorita

## Regras de Negócio 📜🧠
Para as regras de negócio foram usados os seguintes critérios requistos:
- O username e deve ser único
- Um cliente possui apenas uma conta corrente
- Não é possível realizar uma transferência para si mesmo
- Para excluir uma conta não pode haver saldo maior que 0
- Todas as tranferências(recebidas e enviadas) e depósitos devem ser salvas para eventuais consultas
- O Cliente deve salvar uma conta favorita quando realizar uma transferência
## Arquitetura 🏗️🌐
Para este projeto, adotou-se a **Arquitetura Em Camadas**, onde as responsabilidades estão divididas e centralizadas em contextos específicos, bem como o estilo arquitetural **REST**.
- **Camada Web:** contém outras subcamadas que juntas são responsáveis por receber as requisisões de clientes e verificar se os dados recebidos contém todos os requisitos.
- **Camada Service:** é responsável por conter toda a regra de negócio da aplicação.
- **Camada Repository:** é reponsável pela conexão com o Banco de Dados e por realizar as consultas e operações relacionadas à persistência de dados.
- **Camada Model:** contém as entidades de domínio da aplicação.
- **Camada Infra:** é responsável por tratar todas as exceções e devolver respostas personalizadas para o cliente e implementar a infraestrutura de segurança da aplicação.

## Tecnologias, bibliotecas e ferramentas utilizadas
### Backend
- Java ☕️
- Spring boot, Spring Security, Spring Data🍃
- Hibernate 🔍📋
- MySql 🐘
- API's RESTful 🌐
- Padrão DTO  📝
- JWT
- Lombok
- Biblioteca Commons Lang 3

## Como rodar o projeto
### Requisitos
- JDK 17+  instalado
- MySQL instalado
### Passo à passo para Banco PostgresSQL
- Baixar uma cópia do projeto deste repositório
- Caso tenha o git instalado, poderá executar pelo terminal o comando
  ~~~
  git clone https://github.com/danison00/Cadastro-de-Funcionarios.git
  ~~~
- Acessar o arquivo *application.properties* no projeto
- editar adicionando o usuário e senha do seu MySQL
- Executar o projeto
## API's
### Criar Conta
Method: POST
url:
~~~
http://localhost:8080/account
~~~
#### Exemplo:
~~~
{
    "cpf": "9854785",
    "name": "José",
    "telephone": "(91)98758-9696",
    "email": "jose@email.com",
    "typeAccount": "CURRENT",
    "login": {
        "username": "jose",
        "password": "12345"
    }
}
~~~
### Depósito
Method: POST
url:
~~~
http://localhost:8080/transaction/deposit
~~~
~~~
{
    "accountNumber" : "4223" ,
    "value" : "150.0"
}
~~~
