package com.franzoso.consumer;

import com.franzoso.facade.PaymentFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentSuccessResponseConsumer {

    private final PaymentFacade paymentFacade;

    public PaymentSuccessResponseConsumer(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    @RabbitListener(queues = {"payment-success-response-queue"})
    public void receive(@Payload Message message) {
        System.out.println("Message " + message + "  " + LocalDateTime.now());
        String payload = String.valueOf(message.getPayload());
        paymentFacade.paymentSuccess(payload);
    }
}
