package com.front.office.service.impl;

import com.front.office.dto.Trade;
import com.front.office.service.PublisherService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
@Service
public class PublisherServiceImpl implements PublisherService {

    @Value("${message.queue}")
    private String messageQueue;

    @Value("${message.exchange}")
    private String messageExchange;

    @Value("${message.route.key}")
    private String tradeRoutingKey;

    @Autowired
    private RabbitTemplate template;

    @Override
    public boolean publishMessage(Trade trade) {
        System.out.println("Publishing message to queue : " + trade);
        template.convertAndSend(messageExchange, tradeRoutingKey, trade);
        return true;
    }
}
