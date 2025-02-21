package com.franzoso.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.franzoso.dto.PaymentDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentRequestProducer {

    private final AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public PaymentRequestProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void integrate(PaymentDTO payment) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "payment-request-exchange",
                "payment-request-rout-key",
                objectMapper.writeValueAsString(payment)
        );
    }
}
