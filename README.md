# Gráfica Lima — Sistema de Orçamentos

Sistema web desenvolvido para automatizar a solicitação e o gerenciamento de orçamentos de uma gráfica.

O projeto está sendo desenvolvido de forma incremental, começando pelo backend e evoluindo conforme novas funcionalidades são implementadas.

## Tecnologias

* Java 21
* Spring Boot 3
* Spring Web
* Spring Data JPA
* PostgreSQL
* Maven
* IntelliJ IDEA
* Postman
* Git/GitHub

## Objetivo

Permitir que clientes enviem solicitações de orçamento informando os dados do serviço, enquanto o backend processa e armazena essas informações.

## O que foi feito até agora

* Projeto Spring Boot criado do zero.
* Estrutura inicial do backend organizada.
* Configuração do PostgreSQL.
* Criação das entidades e estrutura de persistência.
* Criação de repositories utilizando Spring Data JPA.
* Implementação da camada de serviços.
* Implementação dos controllers da API.
* Definição das regras iniciais para produtos, quantidades e preços.
* Cadastro da tabela de preços dos produtos gráficos.
* Testes dos endpoints utilizando Postman.
* Projeto versionado com Git e preparado para evolução através de commits no GitHub.

## Estrutura

O projeto segue uma separação básica por responsabilidades:

```text
src
└── main
    └── java
        └── com.grafica.orcamentos
            ├── controller
            ├── service
            ├── repository
            ├── entity
            └── dto
```

## Próximos passos

As próximas etapas serão implementadas gradualmente, incluindo a evolução da API, integração com o frontend e posteriormente outras integrações necessárias para o funcionamento completo do sistema.

## Status

Em desenvolvimento — versão inicial.
