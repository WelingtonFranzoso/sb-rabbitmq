package com.franzoso.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentErrorProducer {

    private final AmqpTemplate amqpTemplate;

    public PaymentErrorProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void generateResponse(String message){
        amqpTemplate.convertAndSend(
                "payment-error-response-exchange",
                "payment-error-response-rout-key",
                message);
    }
}
