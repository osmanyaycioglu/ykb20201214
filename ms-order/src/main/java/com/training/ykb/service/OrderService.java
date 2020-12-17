package com.training.ykb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.ykb.error.RestException;
import com.training.ykb.facade.AccountingFacade;
import com.training.ykb.order.models.Order;

@Service
public class OrderService {

    @Autowired
    private AccountingFacade ac;

    public String placeOrderOld(final Order order) {
        return this.ac.payOld(order);
    }

    public String placeOrder(final Order order) throws RestException {
        return this.ac.pay(order);
    }

}
