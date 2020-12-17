package com.training.ykb.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.training.ykb.error.RestException;
import com.training.ykb.order.models.Order;
import com.training.ykb.service.OrderService;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderRest {

    @Value("${a.b.c}")
    private int          abc;

    @Autowired
    private OrderService os;

    @GetMapping("/config")
    public String config() {
        return "Value : " + this.abc;
    }

    @PostMapping("/place")
    public String placeOrder(@Validated @RequestBody final Order order) throws RestException {
        return this.os.placeOrder(order);
    }

    @PostMapping("/placeOld")
    public String placeOrderOld(@Validated @RequestBody final Order order) {
        return this.os.placeOrderOld(order);
    }

    private int count = 0;

    @HystrixCommand(fallbackMethod = "testFallback",
                    commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                                                         value = "500"))
    @GetMapping("/test")
    public String test() {
        this.count++;
        if ((this.count % 3) == 0) {
            throw new IllegalStateException();
        }
        if ((this.count % 5) == 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }

        return "Hello";
    }

    public String testFallback() {
        return "Hello fallback";
    }


}
