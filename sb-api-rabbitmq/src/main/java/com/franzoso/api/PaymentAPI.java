package com.franzoso.api;

import com.franzoso.dto.PaymentDTO;
import com.franzoso.facade.PaymentFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentAPI {

    private final PaymentFacade paymentFacade;

    public PaymentAPI(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    @PostMapping
    public String process(@RequestBody PaymentDTO payment) {
        return paymentFacade.requestPayment(payment);
    }
}
