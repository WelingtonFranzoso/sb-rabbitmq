package com.franzoso.consumer;

import com.franzoso.facade.PaymentFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentErrorResponseConsumer {

    private final PaymentFacade paymentFacade;

    public PaymentErrorResponseConsumer(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    @RabbitListener(queues = {"payment-error-response-queue"})
    public void receive(@Payload Message message) {
        System.out.println("Message " + message + "  " + LocalDateTime.now());
        String payload = String.valueOf(message.getPayload());
        paymentFacade.paymentError (payload);
    }
}
