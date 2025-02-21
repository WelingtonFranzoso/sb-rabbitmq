package com.franzoso.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentSuccessProducer {

    private final AmqpTemplate amqpTemplate;

    public PaymentSuccessProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void generateResponse(String message){
        amqpTemplate.convertAndSend(
                "payment-success-response-exchange",
                "payment-success-response-rout-key",
                message);
    }
}
