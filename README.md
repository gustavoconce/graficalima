# Gráfica Lima: Sistema de Orçamentos

Sistema web desenvolvido para automatizar a solicitação e o gerenciamento de orçamentos de uma gráfica.

O projeto está sendo desenvolvido de forma incremental, começando pelo backend e evoluindo conforme novas funcionalidades são implementadas.

## Tecnologias

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven
* Google Drive API
* OAuth 2.0
* IntelliJ IDEA
* Postman
* Git/GitHub

## Objetivo

Permitir que clientes enviem solicitações de orçamento informando os dados do serviço e anexando a arte final para impressão, enquanto o backend processa e armazena as informações do pedido.

A aplicação também utiliza o Google Drive para armazenar os arquivos enviados, evitando que as artes sejam armazenadas diretamente no banco de dados.

## O que foi feito até agora

* Projeto Spring Boot criado do zero.
* Estrutura inicial do backend organizada.
* Configuração do PostgreSQL.
* Criação das entidades e estrutura de persistência.
* Criação de repositories utilizando Spring Data JPA.
* Implementação da camada de serviços.
* Implementação dos controllers da API.
* Criação de DTOs para entrada e saída de dados.
* Definição das regras iniciais para produtos, quantidades e preços.
* Cadastro da tabela de preços dos produtos gráficos.
* Criação do fluxo de solicitação de pedidos.
* Implementação do recebimento de arquivos utilizando `MultipartFile`.
* Validação das artes enviadas, permitindo somente arquivos PDF de até 10 MB.
* Integração do backend com a API do Google Drive.
* Implementação da autenticação utilizando OAuth 2.0.
* Configuração do armazenamento das credenciais OAuth fora do código-fonte.
* Implementação do upload das artes diretamente para uma pasta específica no Google Drive.
* Armazenamento do identificador do arquivo do Google Drive junto ao pedido.
* Testes dos endpoints utilizando Postman.
* Projeto versionado com Git e preparado para evolução através de commits no GitHub.

## Integração com Google Drive

As artes dos pedidos não são armazenadas diretamente no banco de dados.

O fluxo atual funciona da seguinte forma:

Cliente
   ↓
Pedido
   ↓
Validação da arte
   ↓
Google Drive
   ↓
File ID
   ↓
PostgreSQL

As credenciais utilizadas na integração ficam fora do código-fonte e são configuradas através de variáveis de ambiente.

## Estrutura

O projeto segue uma separação básica por responsabilidades:

src
└── main
    └── java
        └── com.gustavo.orcamentosgrafica
            ├── config
            ├── controller
            ├── service
            ├── repository
            ├── entity
            ├── dto
            └── exception

## Próximos passos

As próximas etapas serão implementadas gradualmente, incluindo a organização das artes no Google Drive por pedido, evolução do tratamento de erros, segurança da API, integração com o frontend, Docker e outras funcionalidades necessárias para o funcionamento completo do sistema.

## Status

Em desenvolvimento — versão inicial.
