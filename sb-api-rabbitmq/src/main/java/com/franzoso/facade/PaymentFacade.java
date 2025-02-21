package com.franzoso.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.franzoso.dto.PaymentDTO;
import com.franzoso.producer.PaymentRequestProducer;
import org.springframework.stereotype.Service;

@Service
public class PaymentFacade {

    private final PaymentRequestProducer producer;

    public PaymentFacade(PaymentRequestProducer producer) {
        this.producer = producer;
    }

    public String requestPayment(PaymentDTO payment) {
        try {
            producer.integrate(payment);
        } catch (JsonProcessingException e) {
            return "An error occurred while requesting payment .. " + e.getMessage();
        }
        return "Payment awaiting confirmation...";
    }

    public void paymentError(String payload) {
        System.err.println("==== ERROR RESPONSE =====" + payload);
    }

    public void paymentSuccess(String payload) {
        System.out.println("==== SUCCESS RESPONSE =====" + payload);
    }
}
