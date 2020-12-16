package com.training.ykb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.ykb.facade.AccountingClient;
import com.training.ykb.order.models.Order;

@Service
public class OrderService {

    @Autowired
    private AccountingClient ac;

    public String placeOrder(final Order order) {
        return this.ac.pay(order);
    }

}
