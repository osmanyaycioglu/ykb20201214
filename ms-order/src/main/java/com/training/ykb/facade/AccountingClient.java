package com.training.ykb.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.ykb.order.models.Order;
import com.training.ykb.order.models.PaymentRequest;

@Service
public class AccountingClient {

    @Autowired
    private RestTemplate rt;

    public String pay(final Order order) {
        PaymentRequest pr = new PaymentRequest();
        pr.setOrderId(1);
        pr.setAmount(100);
        return this.rt.postForObject("http://ACCOUNTING/accounting/payment/request",
                                     pr,
                                     String.class);
    }

}
