# Projeto de Persistência Poliglota: Oficina Mecânica Inteligente (Serviço S2 - API Backend)

## 1. Explicação do Tema Escolhido

Este projeto implementa o sistema de backend para uma **Oficina Mecânica Inteligente**. O objetivo é demonstrar o conceito de **Persistência Poliglota**, onde diferentes tecnologias de banco de dados são escolhidas estrategicamente para resolver problemas específicos, em vez de usar uma única solução para todos os tipos de dados.

O sistema consiste em uma API REST (este serviço, S2) que gerencia três entidades centrais do negócio:
- **Customers (Clientes):** Dados cadastrais dos clientes.
- **Service Orders (Ordens de Serviço):** Informações detalhadas sobre os trabalhos realizados.
- **Diagnostic Logs (Logs de Diagnóstico):** Registros de eventos e erros dos veículos.

## 2. Justificativas e Implementação do S2

### Arquitetura do Serviço S2
O serviço S2 foi construído utilizando **Java 17** e **Spring Boot**, seguindo os princípios da **Arquitetura Hexagonal (Portas e Adaptadores)**. Essa abordagem garante um forte desacoplamento entre o núcleo de negócio da aplicação (a camada `domain`) e as tecnologias externas (frameworks web, bancos de dados), resultando em um código mais limpo, testável e fácil de manter.

O fluxo de uma requisição sempre passa por adaptadores (web) para portas de entrada (casos de uso), que orquestram a lógica de negócio e usam portas de saída (interfaces de repositório) para persistir dados através de outros adaptadores (implementações de banco de dados).

### Justificativa para Cada Banco de Dados

#### a) PostgreSQL (Banco de Dados Relacional - RDB)
* **Dados Armazenados:** `Customer` (Clientes).
* **Justificativa:** Os dados de clientes são altamente estruturados e relacionais. Um banco relacional como o PostgreSQL é a escolha ideal por garantir **consistência forte (ACID)** e **integridade referencial**, que são críticas para dados cadastrais. A natureza tabular e os relacionamentos bem definidos são perfeitos para este tipo de informação.

#### b) MongoDB (Banco de Dados de Documento - DB1)
* **Dados Armazenados:** `ServiceOrder` (Ordens de Serviço).
* **Justificativa:** Uma Ordem de Serviço é um **agregado natural de dados** (incluindo uma lista de serviços e peças). O modelo de documento do MongoDB permite armazenar toda a OS em um único objeto JSON, o que é extremamente eficiente para leitura e escrita, evitando `JOINs` complexos. Seu **esquema flexível** é uma vantagem, permitindo que OS futuras possam incluir novos tipos de dados (como fotos) sem alterar a estrutura do banco.

#### c) Cassandra (Banco de Dados de Coluna Larga - DB2)
* **Dados Armazenados:** `DiagnosticLog` (Logs de Diagnóstico).
* **Justificativa:** Logs de diagnóstico são dados de **série temporal**, gerados em **alto volume e com alta velocidade de escrita**. O Cassandra é projetado para essa carga de trabalho, oferecendo performance de escrita excepcional e escalabilidade linear. O padrão de consulta principal ("buscar todos os logs de um veículo") mapeia perfeitamente para o modelo de chave de partição do Cassandra, garantindo leituras muito rápidas.

## 3. Como Executar o Projeto

Esta seção contém todos os recursos e passos necessários para executar o ambiente completo a partir de uma máquina limpa.

### Pré-requisitos
* Git
* Docker e Docker Compose
* Java 17+ (ou superior)
* Maven

### Passos para Execução
1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/KawanMark/FeicinaClientS1.git
    ```

2.  **Navegue até a pasta do serviço S2:**
    ```bash
    cd <PASTA_DO_PROJETO>/s2-oficina-api
    ```

3.  **Construa o projeto com Maven:**
    Este passo compila o código e cria o arquivo `.jar` que será usado pelo Docker.
    ```bash
    mvn clean package
    ```

4.  **Inicie todo o ambiente com Docker Compose:**
    Este único comando irá construir a imagem da aplicação S2 e iniciar os 4 containers de banco de dados (PostgreSQL, MongoDB, Cassandra, Neo4j) em uma rede dedicada.
    ```bash
    docker-compose up --build
    ```

### Verificação
* A API do Serviço S2 estará disponível em `http://localhost:8080`.
* Você pode fazer um teste rápido de saúde acessando `GET http://localhost:8080/ping`.
* Para ver os containers rodando, use o comando `docker ps`.

## 4. Endpoints da API

* `POST /clients`: Cria um novo cliente.
* `GET /clients`: Lista todos os clientes.
* `GET /clients/{id}`: Busca um cliente por ID.
* `POST /service-orders`: Cria uma nova ordem de serviço.
* `POST /diagnostic-logs`: Cria um novo log de diagnóstico.
