package com.training.ykb.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.order.models.Order;
import com.training.ykb.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderRest {

    @Autowired
    private OrderService os;

    @PostMapping("/place")
    public String placeOrder(@RequestBody final Order order) {
        return this.os.placeOrder(order);
    }

}
