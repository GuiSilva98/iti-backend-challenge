# Desafio Backend Itaú Unibanco 

O desafio proposto consiste no desenvolvimento de uma API para validação de senhas, com base em um conjunto definido de regras e validações.

## Solução

O projeto adota uma arquitetura em camadas, composta por Controller, Service e Usecase, com responsabilidades bem definidas em cada nível.
A camada de **Controller** é responsável por expor o endpoint da aplicação, receber a requisição e encaminhá-la para o serviço indicado, cuidando também da formatação das respostas.
As regras de negócio estão centralizadas na camada de **Usecase**, facilitando a manutenção e a adição de novas funcionalidades.
Já a camada de **Service** atua como intermediária, orquestrando as chamadas ao usecase e podendo agrupar ou estender comportamentos conforme necessário.

## Contexto

A aplicação expõe um endpoint para validação de uma senha com base em alguns requisitos, sendo eles: 

- 9 ou mais caracteres (Espaços em branco não são considerados caracteres válidos)
- Ao menos 1 número
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
- Não possuir caracteres repetidos dentro do conjunto

## Tecnologias utilizadas

- Kotlin 2.0.21
- Spring Boot 3.4.5
- Gradle 8.13
- JVM 17
- Kover 0.9.1

## Execução do projeto

Para iniciar esse projeto, é necessário executar o comando:

```bash
   ./gradlew clean build bootRun
```

## Endpoints

#### Valida uma senha

```http
  GET /validate/passwords/{password}
```

| Parâmetro  | Tipo       | Descrição                             |
|:-----------| :--------- |:--------------------------------------|
| `password` | `string` | **Obrigatório**. Senha para validação |


## Execução de testes

Para iniciar os testes, é necessário executar o comando:

```bash
   ./gradlew clean build test
```

Para verificar a cobertura de testes deste projeto, é necessário executar o comando:

```bash
   ./gradlew clean build koverHtmlReport
```

## Autor

- [@guisilva98](https://www.github.com/guisilva98)