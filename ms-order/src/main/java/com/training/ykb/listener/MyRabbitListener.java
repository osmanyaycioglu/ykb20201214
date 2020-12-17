package com.training.ykb.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify_response_queue",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "notify_response_exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notify_response"))
    public void handleNotificationResponseMessage(final String str) {
        System.out.println("Sonuç : " + str);
    }

}
