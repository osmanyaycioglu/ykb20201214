package com.training.ykb.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.models.PaymentRequest;

@RestController
@RequestMapping("/accounting")
public class AccountingRest {

    @Value("${server.port}")
    private int port;

    @PostMapping("/payment/request")
    public String pay(@Validated @RequestBody final PaymentRequest pr) {
        System.out.println("Request accepted : " + pr);
        return "OK-" + this.port;
    }

}
