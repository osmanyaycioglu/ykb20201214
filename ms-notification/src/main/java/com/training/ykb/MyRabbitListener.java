package com.training.ykb;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notify_queue",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "notify_exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notify_request"))
    @SendTo("notify_response_exchange/notify_response")
    public String handleNotificationMessage(final Notification str) {
        System.out.println("Gelen str : " + str);
        return "notification : " + str.getDestination() + " mesaj atıldı";
    }

}
