# Spring Boot com RabbitMQ

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/WelingtonFranzoso/sb-rabbitmq/blob/main/LICENSE) 

# Sobre o projeto

Este projeto consiste em dois microserviços desenvolvidos com Spring Boot que utilizam RabbitMQ para comunicação assíncrona, simulando um fluxo de processamento de pagamentos.
O sb-api-rabbitmq (Producer & Consumer) envia requisições de pagamento para uma fila RabbitMQ, contendo os detalhes da transação no PaymentDTO. 
O sb-worker-rabbitmq (Consumer & Producer) consome essas mensagens, processa a transação e gera um resultado de forma aleatória (sucesso ou erro). 
O resultado é então enviado para filas específicas (sucesso ou erro), que são consumidas novamente pelo sb-api-rabbitmq, permitindo o tratamento da resposta da transação.

# Funcionalidades
## sb-api-rabbitmq (Producer & Consumer)
- Envia requisições de pagamento para uma fila RabbitMQ contendo os dados da transação (Producer).
- Consome mensagens das filas de sucesso e erro para processar o resultado do pagamento (Consumer).
- Registra e trata respostas das transações processadas.

## sb-worker-rabbitmq (Consumer & Producer)
- Consome mensagens da fila de requisições de pagamento (Consumer).
- Processa a transação e gera um resultado aleatório (sucesso ou erro).
- Envia o resultado para as filas correspondentes (Producer).

# Tecnologias utilizadas

- Java 17+
- Spring Boot
- Maven
- RabbitMQ
- Docker

# Como executar o projeto
## Back end
### Pré-requisitos: 
- Java 17 ou superior
- Maven (para construção do projeto)

```bash
# clonar repositório
git clone git@github.com:WelingtonFranzoso/sb-rabbitmq.git

# entrar na pasta do projeto back end
cd sb-rabbitmq

# Subindo um ambiente Kafka via Docker
docker-compose up -d

# entrar na pasta do projeto Producer
cd sb-api-rabbitmq

# executar o projeto
./mvnw spring-boot:run

# entrar na pasta do projeto Consumer
cd sb-worker-rabbitmq

# executar o projeto
./mvnw spring-boot:run
```

# Endpoints Disponíveis

| Método | Endpoint      | Descrição             |
|:------:|:-------------:|:---------------------:|
| Post    | /payment      | Envia uma mensagem com as informações da classe PaymentDTO para uma fila do RabbitMQ |


# Contribuição

1. Fork este repositório

2. Crie uma branch (feature-nova)

3. Commit suas mudanças (git commit -m 'Add nova feature')

4. Push para sua branch (git push origin feature-nova)

5. Crie um Pull Request

# Licença

- Este projeto está sob a licença MIT. Sinta-se livre para usá-lo e modificá-lo.
