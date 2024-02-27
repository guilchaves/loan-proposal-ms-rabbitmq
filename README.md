# Caso de Estudo - Microsserviços para Análise de Crédito 

Este é um projeto Java Spring desenvolvido como parte de um estudo sobre arquitetura de microsserviços e mensageria. Ele fornece uma aplicação baseada em microsserviços para proposta de solicitação de empréstimo, análise de crédito 
e notificação.

## Objetivos do estudo

- Implementação de arquitetura de Microsserviços</br>
- Mensageria com *RabbitMQ* para comunicação assíncrona a partir de filas, exchanges e dead letter queues</br>
- Utilização do ecossistema Spring</br>
- Padrão de projeto Strategy</br>
- Integração com AWS Simple Notification Service para envio de sms</br>

## Resumo do sistema

O Sistema de Solicitação de Empréstimo é composto por três microsserviços interconectados, cada um desempenhando um papel independente no processo de solicitação e análise de empréstimos:

1. Microsserviço de Geração de Proposta:
    - Responsável por gerar propostas de solicitação de empréstimo com base nas informações fornecidas pelo cliente.
    - Coleta os dados necessários, como valor do empréstimo, prazo de pagamento e informações do cliente, para criar uma proposta de empréstimo.
    - Envia a proposta gerada para o microsserviço de análise de crédito para avaliação.
    - Comunica-se com o microsserviço de notificação quando uma proposta é gerada.

2. Microsserviço de Análise de Crédito:
    - Encarregado de analisar as propostas de empréstimo geradas pelo microsserviço de geração de proposta.
    - Simula consulta de APIs externas para analisar diversos critérios de pontuação, como nome sujo do cliente, renda, prazo de pagamento, empréstimos existentes, score financeiro.
    - Com base na análise realizada, decide se a proposta é aceita ou recusada.
    - Envia o resultado da análise para o microsserviço de notificação, comunicando a decisão tomada.

3. Microsserviço de Notificação:
    - Responsável por comunicar ao cliente o andamento do processo de solicitação de empréstimo.
    - Recebe informações sobre o status da proposta de empréstimo do microsserviço de análise de crédito.
    - Envia notificações ao cliente, informando se a proposta foi aceita ou recusada, e fornece detalhes adicionais conforme necessário.
    - Garante uma comunicação eficaz e transparente entre o sistema e o cliente durante todo o processo de solicitação de empréstimo.

## Como rodar o projeto

Em breve.
