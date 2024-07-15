# Controle de Agendamentos de Vagas

## 1 - Descrição do Projeto

Este projeto tem como objetivo desenvolver uma aplicação para o controle de agendamentos de vagas, permitindo o registro de cadastros e implementando validações essenciais para garantir a integridade dos dados e a performance do sistema. A aplicação é projetada para lidar com uma média de 300 agendamentos diários de vários solicitantes. A aplicação permite o cadastro de vagas, solicitantes e agendamentos.

## 2 - Tecnologias Utilizadas

- **Back-end**: Java 17 com Spring Boot, JPA/Hibernate
- **Front-end**: JSF com PrimeFaces
- **Banco de Dados**: HSQLDB

## 3 - Funcionalidades

### 3.1 - Vagas
#### 3.1.1 - Listagem de Vagas Cadastradas
- http://localhost:9494/vagas
#### 3.1.2 - Cadastro
- http://localhost:9494/vagas/novo

### 3.2 - Solicitantes
#### 3.2.1 - Listagem de Solicitantes Cadastradas
- http://localhost:9494/solicitantes
#### 3.2.2 - Cadastro
- http://localhost:9494/solicitantes/novo

### 3.3 - Agendamentos
#### 3.3.1 - Listagem e Consulta de Agendamentos Cadastradas
- http://localhost:9494/agendamentos
#### 3.3.2 - Cadastro
- http://localhost:9494/agendamentos/novo

### 3.4 - Consulta do Total de Agendamentos por Solicitante
#### 3.4.1 - Consulta
- http://localhost:9494/agendamentos/consulta-totais

## 4 - Configurações
Alguns itens de configuração podem ser encontrados no arquivo application.properties, nele você pode verificar a porta e o caminho configurado par agravação dos arquivos relacionados a base de dados.

## 5 - Executando 
1) Realize o clone o repositório:

   ```bash
   git clone https://github.com/guitarpe/logone.git
   cd logone

2) Utilize o comando abaixo para compilação do projeto:
    ```bash
    mvn install -DskipTests
    ```

3) Para iniciá-lo, utilize o comando abaixo:
    ```bash
    java -jar -Dserver.port=9494 target/logone.jar
    ```
4) Abra o negador e acesse:
http://localhost:9494/