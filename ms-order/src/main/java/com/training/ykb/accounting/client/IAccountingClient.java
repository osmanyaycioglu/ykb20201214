package com.training.ykb.accounting.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.ykb.order.models.PaymentRequest;

@FeignClient(name = "ACCOUNTING")
@RequestMapping("/accounting")
public interface IAccountingClient {

    @PostMapping("/payment/request")
    public String pay(final PaymentRequest pr);
}
