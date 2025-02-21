package com.franzoso.consumer;

import com.franzoso.producer.PaymentErrorProducer;
import com.franzoso.producer.PaymentSuccessProducer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PaymentRequestConsumer {

    private final PaymentErrorProducer errorProducer;
    private final PaymentSuccessProducer successProducer;

    public PaymentRequestConsumer(PaymentErrorProducer errorProducer, PaymentSuccessProducer successProducer) {
        this.errorProducer = errorProducer;
        this.successProducer = successProducer;
    }

    @RabbitListener(queues = {"payment-request-queue"})
    public void receiveMessage(@Payload Message message) {
        System.out.println(message);
        if (new Random().nextBoolean()) {
            successProducer.generateResponse("Payment Success " + message);
        } else {
            errorProducer.generateResponse("Payment Error " + message);
        }
    }
}
